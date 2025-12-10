#!/usr/bin/env python3

import json
import random
import undetected_chromedriver as uc
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from bs4 import BeautifulSoup
import csv
import time
from urllib.parse import quote_plus


class PCPartPickerScraper:
    def __init__(self, search_query: str, headers_file="headers.json"):
        self.search_query = search_query
        self.headers_file = headers_file
        self.header_pool = self.load_headers()
        self.product_list = []

    def load_headers(self):
        with open(self.headers_file, "r", encoding="utf-8") as f:
            return json.load(f)

    def get_random_header(self):
        return random.choice(self.header_pool)

    def scrape_pages(self, max_pages=5):
        hdr = self.get_random_header()
        options = uc.ChromeOptions()

        # Headless mode (uncomment if you want)
        # options.add_argument("--headless=new")
        options.add_argument("--disable-gpu")
        options.add_argument("--no-sandbox")
        options.add_argument("--disable-dev-shm-usage")

        # Disable images & CSS for speed
        prefs = {
            "profile.managed_default_content_settings.images": 2,
            "profile.managed_default_content_settings.stylesheets": 2,
        }
        options.add_experimental_option("prefs", prefs)

        # Set random user-agent
        if "User-Agent" in hdr:
            options.add_argument(f"user-agent={hdr['User-Agent']}")

        options.add_argument("--disable-blink-features=AutomationControlled")

        driver = uc.Chrome(options=options)
        html = ""

        try:
            print("[+] Loading initial search page…")
            driver.get("https://pcpartpicker.com/search/")

            # enter search query in input box
            search_input = WebDriverWait(driver, 5).until(
                EC.presence_of_element_located((By.CSS_SELECTOR, "input[type='text']"))
            )
            search_input.clear()
            search_input.send_keys(self.search_query)
            search_input.send_keys(Keys.ENTER)

            print("[+] Searching...")

            # loop through pages
            for page in range(1, max_pages + 1):
                print(f"[+] Loading page {page}...", end="\r")
                # navigate to next page if page > 1
                if page > 1:
                    url_query = quote_plus(self.search_query)
                    driver.get(
                        f"https://pcpartpicker.com/search/?q={url_query}&page={page}"
                    )

                try:
                    WebDriverWait(driver, 5).until(
                        EC.presence_of_all_elements_located(
                            (By.CSS_SELECTOR, "td.td__name a")
                        )
                    )
                except:
                    pass

                html = driver.page_source
                self.parse_html(html)
                time.sleep(1)  # small delay between pages

        except Exception as e:
            print(f"[-] Unexpected error: {e}")
        finally:
            driver.quit()

    def parse_html(self, html):
        soup = BeautifulSoup(html, "html.parser")
        products = soup.select("ul.list-unstyled > li")

        for product in products:
            name_tag = product.select_one(".search_results--link a")
            img_tag = product.select_one(".search_results--img img")

            name = name_tag.text.strip() if name_tag else None
            img_url = img_tag["src"].strip() if img_tag else None

            if name and img_url:
                if img_url.startswith("//"):
                    img_url = "https:" + img_url
                if img_url.startswith("/static/forever/img/no-image.png"):
                    img_url = ""

                self.product_list.append({"name": name, "image": img_url})

    def save_csv(self, filename: str):
        with open(filename + ".csv", "a", encoding="utf-8", newline="") as f:
            writer = csv.DictWriter(f, fieldnames=["name", "image"])
            if f.tell() == 0:
                writer.writeheader()
            for product in self.product_list:
                writer.writerow(product)
        print(f"[+] Saved {len(self.product_list)} products → {filename}.csv")

    def run(self, max_pages=5):
        self.scrape_pages(max_pages=max_pages)
        if self.product_list:
            self.save_csv(self.search_query)
        else:
            print("[-] No products found.")


def main():
    categories = [
        # "Processor",
        # "Memory",
        "MotherBoard",
        "Internal Hard Drive",
        "Video Card",
        "Power Supply",
        "Case",
        "Cpu cooler",
    ]

    for category in categories:
        scraper = PCPartPickerScraper(category)
        scraper.run()


if __name__ == "__main__":
    main()
