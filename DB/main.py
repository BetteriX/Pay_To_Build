#!/usr/bin/env python3

import warnings

warnings.simplefilter(action="ignore", category=FutureWarning)
warnings.filterwarnings("ignore")

import time
import pypartpicker
from pypartpicker.errors import CloudflareException, RateLimitException
import random


client = pypartpicker.Client()


def safe_get_part(query, region="us", page=1, retries=3):
    for attempt in range(retries):
        try:
            return client.get_part_search(query, region=region, page=page)
        except (CloudflareException, RateLimitException) as e:
            print(
                f"[{type(e).__name__}] Page {page} attempt {attempt + 1}/{retries}: {e}"
            )
            time.sleep(10)
    return None


def scrape_category(name: str):
    page = 1
    region = "us"
    fname = f"{name.lower()}.csv"
    try:
        with open(fname, "w", encoding="utf-8") as f:
            f.write("Name,Image URL\n")

            while True:
                result = safe_get_part(name, region=region, page=page)
                if not result or not result.parts:
                    print("No more results or fetch failed — stopping.")
                    break

                print(f"{name}: \n=== Page {page}/{result.total_pages} ===", end="\r")
                for summary in result.parts:
                    name = summary.name
                    image = summary.image_urls[0] or ""
                    # print(name, image)
                    f.write(f"{name},{image}\n")
                    f.flush()
                    time.sleep(random.uniform(0.5, 1.5))  # avoid rate limit

                if page >= result.total_pages:
                    break
                page += 1
                time.sleep(random.uniform(1, 3))  # pause between pages

    except KeyboardInterrupt:
        print("\nScript stopped by user (Ctrl+C)!")

    print(f"{name}: Finished scanning")


def main():
    # Felkel sorolni még
    categories = [
        "Processor",
        "Memory",
        "Internal Hard Drive",
        "Video Card",
    ]


if __name__ == "__main__":
    main()
