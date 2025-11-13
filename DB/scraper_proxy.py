#!/usr/bin/env python3

import os
import pypartpicker
import json
import random
import time
from requests.exceptions import RequestException
from pypartpicker import CloudflareException, RateLimitException
from requests_html import HTMLSession
from dotenv import load_dotenv

load_dotenv()
username = os.getenv("PROXY_USERNAME")
password = os.getenv("PROXY_PASS")

PROXY = f"https://{username}:{password}@gate.decodo.com:7000"
PROXIES = {"http": PROXY, "https": PROXY}


session = HTMLSession()
session.proxies.update(PROXIES)

with open("headers.json", "r", encoding="utf-8") as f:
    HEADER_POOL = json.load(f)


def Get_Random_Header():
    return random.choice(HEADER_POOL)


def response_retriever(url):
    headers = Get_Random_Header()
    session.headers.update(headers)

    time.sleep(random.uniform(0.5, 1))

    try:
        resp = session.get(url, timeout=15)

        if resp.status_code == 403:
            time.sleep(random.uniform(0.5, 1))

            # continue  # retry same URL; Decodo gives a new IP

        resp.raise_for_status()
        return resp

    except RequestException as e:
        print(f"{attempt}. Request failed: {e}. Retrying...")


client = pypartpicker.Client(response_retriever=response_retriever)
attempt = 0


def safe_get_part(query, region="us", page=1):
    global attempt, client

    try:
        return client.get_part_search(query, region=region, page=page)

    except (CloudflareException, RateLimitException) as e:
        attempt += 1
        print(f"[{type(e).__name__}] Page {page} attempt {attempt}: {e}")
        print("Sleeping for 60 seconds before retry...")
        time.sleep(10)

        # os.system("clear")

    except Exception as e:
        print(f"[!] Unexpected error on page {page}: {e}")
        time.sleep(10)

    return None


def scrape_category(name: str):
    os.system("clear")
    page = 1
    region = "us"
    fname = f"{name.lower()}-image.csv"
    try:
        with open(fname, "w", encoding="utf-8") as f:
            f.write("Name,Image URL\n")
            first_line = True
            while True:
                result = safe_get_part(name, region=region, page=page)
                if not result:
                    print(f"[!] Failed to fetch page {page}, skipping...")
                    break

                print(f"{name}: === Page {page}/{result.total_pages} ===", end="\r")
                for summary in result.parts:
                    # f.write(summary.url)
                    part_name = summary.name
                    image = summary.image_urls[0] or ""
                    # print(name, image)
                    if summary.type == name:
                        f.write(f"{part_name},{image}\n")
                        f.flush()
                    # time.sleep(random.uniform(0.5, 0.75))  # avoid rate limit

                if page >= result.total_pages:
                    break
                page += 1
                # time.sleep(random.uniform(5, 10))

    except KeyboardInterrupt:
        print("\nScript stopped by user (Ctrl+C)!")

    print(f"{name}: Finished scanning")


def main():
    # client = pypartpicker.Client(response_retriever=response_retriever)

    # Felkel sorolni még
    categories = [
        # "Processor",  # Got it
        # "cpu-cooler",
        "Memory",  # Need now
        # "case",
        # "Motherboard",
        # "power-supply",
        # "Internal-Hard-Drive",
        # "External-Hard-Drive",
        # "Video-Card",
        # "Case-Fan",
        # "Fan-Controller",
    ]

    for word in categories:
        scrape_category(word)


if __name__ == "__main__":
    main()
