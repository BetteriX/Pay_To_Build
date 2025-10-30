#!/usr/bin/env python3

import warnings
import time
import pypartpicker
from pypartpicker.errors import CloudflareException, RateLimitException
import random

warnings.simplefilter(action="ignore", category=FutureWarning)
warnings.filterwarnings("ignore")

client = pypartpicker.Client()
attempt = 0


def safe_get_part(query, region="us", page=1):
    global attempt
    try:
        return client.get_part_search(query, region=region, page=page)
    except (CloudflareException, RateLimitException) as e:
        attempt += 1
        print(f"[{type(e).__name__}] Page {page} attempt {attempt}: {e}")
        time.sleep(180)  # Változtatni kell még ezzen fixen
    return None


def scrape_category(name: str):
    page = 1
    region = "us"
    fname = f"{name.lower()}-image.csv"
    try:
        with open(fname, "w", encoding="utf-8") as f:
            f.write("Name,Image URL\n")

            while True:
                result = safe_get_part(name, region=region, page=page)
                if not result or not result.parts:
                    print("No more results or fetch failed — stopping.")
                    break

                print(f"{name}: === Page {page}/{result.total_pages} ===", end="\r")
                for summary in result.parts:
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
                time.sleep(random.uniform(3, 10))  # Le kell tesztelni!!!

    except KeyboardInterrupt:
        print("\nScript stopped by user (Ctrl+C)!")

    print(f"{name}: Finished scanning")


def main():
    # Felkel sorolni még
    categories = [
        # "Processor",
        # "Memory",
        "Internal Hard Drive",
        "External Hard Drive",
        "Video Card",
        "Case Fan",
        "Fan Controller",
    ]

    for word in categories:
        scrape_category(word)


if __name__ == "__main__":
    main()
