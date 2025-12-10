#!/usr/bin/env python3

import warnings
import time
import pypartpicker
from requests.exceptions import RequestException
from pypartpicker.errors import CloudflareException, RateLimitException
import random
import mac
import os
import csv
import json
from requests_html import HTMLSession

warnings.simplefilter(action="ignore", category=FutureWarning)
warnings.filterwarnings("ignore")


def response_retriever(url):
    session.headers.update(Get_Random_Header())

    time.sleep(random.uniform(0.5, 1))

    try:
        resp = session.get(url, timeout=15)

        if resp.status_code == 403:
            time.sleep(random.uniform(0.5, 1))

        resp.raise_for_status()
        return resp

    except RequestException as e:
        print(f"{attempt}. Request failed: {e}. Retrying...")
        time.sleep(random.uniform(1, 2))
        return response_retriever(url)


# Global client
client = pypartpicker.Client(response_retriever=response_retriever)
interface = "wlp1s0"
ssid = "Telekom-5A4A71"
attempt = 0

session = HTMLSession()

with open("headers.json", "r", encoding="utf-8") as f:
    HEADER_POOL = json.load(f)


def Get_Random_Header():
    return random.choice(HEADER_POOL)


def rotate_mac_and_reconnect():
    """Rotate MAC address and reconnect Wi-Fi."""
    old_mac = mac.get_current_mac_address(interface)
    print("[*] Old MAC address:", old_mac)

    new_mac = mac.get_random_mac_address()
    mac.change_mac_address(interface, new_mac)
    print("[+] New MAC address:", new_mac)

    mac.reconnect_wifi(interface, ssid)
    print("[*] Reconnected Wi-Fi")


def safe_get_part(query, region="us", page=1, max_retries=10):
    """Fetch part info safely with retries and MAC rotation."""
    global client
    attempt = 0

    while attempt < max_retries:
        try:
            return client.get_part_search(query, region=region, page=page)

        except (CloudflareException, RateLimitException) as e:
            attempt += 1
            print(f"[{type(e).__name__}] Page {page} attempt {attempt}: {e}")
            # rotate_mac_and_reconnect()
            client = pypartpicker.Client(
                response_retriever=response_retriever
            )  # reset client after reconnect
            sleep_time = random.uniform(60, 120)
            print(f"Sleeping for {sleep_time:.1f} seconds before retry...")
            time.sleep(sleep_time)

        except Exception as e:
            attempt += 1
            print(f"[!] Unexpected error on page {page} attempt {attempt}: {e}")
            time.sleep(random.uniform(5, 10))

    print(f"[!] Giving up after {max_retries} retries on page {page}")
    return None


def scrape_category(name: str, region="us"):
    """Scrape all pages of a given category and save to CSV."""
    os.system("clear")
    page = 1
    fname = f"{name.lower().replace(' ', '_')}.csv"
    headers_written = False

    try:
        with open(fname, "w", encoding="utf-8", newline="") as f:
            writer = None

            while True:
                result = safe_get_part(name, region=region, page=page)
                if not result:
                    print(f"[!] Failed to fetch page {page}, skipping...")
                    break

                print(f"{name}: === Page {page}/{result.total_pages} ===", end="\r")

                for summary in result.parts:
                    part_name = summary.name
                    image = summary.image_urls[0] if summary.image_urls else ""
                    part = client.get_part(summary.url)

                    if not headers_written:
                        headers = ["Name", "Image URL"] + list(part.specs.keys())
                        writer = csv.writer(f)
                        writer.writerow(headers)
                        headers_written = True

                    row = [part_name, image] + list(part.specs.values())
                    writer.writerow(row)
                    f.flush()

                if page >= result.total_pages:
                    break

                page += 1
                sleep_time = random.uniform(5, 10)
                time.sleep(sleep_time)

    except KeyboardInterrupt:
        print("\n[!] Script stopped by user (Ctrl+C)!")
    except Exception as e:
        print(f"[!] Unexpected error while scraping {name}: {e}")

    print(f"\n{name}: Finished scanning. Data saved to {fname}")


def main():
    categories = [
        "Processor",
        # "Memory",
        # "Internal-Hard-Drive",
        # "External-Hard-Drive",
        # "Video-Card",
        # "Case-Fan",
        # "Fan-Controller",
    ]

    for category in categories:
        scrape_category(category)


if __name__ == "__main__":
    main()
