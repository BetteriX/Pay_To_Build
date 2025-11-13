#!/usr/bin/env python3

import warnings
import time
import pypartpicker
from pypartpicker.errors import CloudflareException, RateLimitException
import random
import mac
import os

warnings.simplefilter(action="ignore", category=FutureWarning)
warnings.filterwarnings("ignore")

client = pypartpicker.Client()
attempt = 0
interface = "wlp1s0"
ssid = "eduroam"
original_mac_address = mac.get_current_mac_address(interface)


def safe_get_part(query, region="us", page=1, max_retries=99):
    """Fetch part info safely with retries, MAC rotation, and Wi-Fi reconnect."""
    global attempt, client

    for retry in range(max_retries):
        try:
            return client.get_part_search(query, region=region, page=page)

        except (CloudflareException, RateLimitException) as e:
            attempt += 1
            print(f"[{type(e).__name__}] Page {page} attempt {attempt}: {e}")

            # Rotate MAC
            old_mac = mac.get_current_mac_address(interface)
            print("[*] Old MAC address:", old_mac)

            new_mac = mac.get_random_mac_address()
            mac.change_mac_address(interface, new_mac)
            print("[+] New MAC address:", new_mac)

            # Reconnect Wi-Fi
            mac.reconnect_wifi(interface, ssid)

            # Recreate the pypartpicker client (new session)
            client = pypartpicker.Client()
            print("[*] Refreshed pypartpicker client after reconnect.")

            # Wait before retry
            print("Sleeping for 60 seconds before retry...")
            time.sleep(10)

            # os.system("clear")

        except Exception as e:
            print(f"[!] Unexpected error on page {page}: {e}")
            time.sleep(10)

    print(f"[!] Giving up after {max_retries} retries on page {page}")
    return None


def scrape_category(name: str):
    os.system("clear")
    page = 1
    region = "uk"
    fname = f"{name.lower()}-image.csv"
    try:
        with open(fname, "w", encoding="utf-8") as f:
            f.write("Name,Image URL\n")

            while True:
                result = safe_get_part(name, region=region, page=page)
                if not result:
                    print(f"[!] Failed to fetch page {page}, skipping...")
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
                time.sleep(random.uniform(5, 10))

    except KeyboardInterrupt:
        print("\nScript stopped by user (Ctrl+C)!")

    print(f"{name}: Finished scanning")


def main():
    # Felkel sorolni még
    categories = [
        # "Processor", # Got it
        "memory",  # Need now
        # "Internal-Hard-Drive",
        # "External-Hard-Drive",
        # "Video-Card",
        # "Case-Fan",
        # "Fan-Controller",
    ]

    # for word in categories:
    #    scrape_category(word)


if __name__ == "__main__":
    main()
