#!/usr/bin/env python3

import warnings

warnings.simplefilter(action="ignore", category=FutureWarning)
warnings.filterwarnings("ignore")

# import os
# import mysql.connector
# from dotenv import load_dotenv
import time
import pypartpicker
from pypartpicker.errors import CloudflareException, RateLimitException
import random


"""
async def parts():
    page = 1
    client = pypartpicker.Client
    test = pypartpicker.PRODUCT_UPS_PATH
    test.
    search = await client.get_part_search("AMD Processor", region="uk", page=page)
    # while page < 2:

    for part in search.parts:
        try:
            cpu = await client.get_part(part.url)
            print(f"\n--- {cpu.name} ---")
            for spec, value in cpu.specs.items():
                print(f"{spec}: {value}")
        except NetworkError as e:
            print(f"Network error: {e}")
            print("Waiting...")
            await asyncio.sleep(10)
        except Exception as e:
            print(e)
            print("Waiting...")
            await asyncio.sleep(2)
"""

client = pypartpicker.Client()


def safe_get_part(query, region="us", page=1):
    try:
        return client.get_part_search(query, region=region, page=page)

    except CloudflareException as e:
        print(f"[CloudflareException] Attempt failed: {e}")
        time.sleep(10)  # wait before retrying

    except RateLimitException as e:
        print(f"[RateLimitException] You hit the PCPartPicker rate limit: {e}")
        print("Sleeping 60 seconds to cool down...")
        time.sleep(60)


def main():
    page = 1
    region = "us"

    with open("cpu.csv", "w", encoding="utf-8") as f:
        f.write("Name,Image URL\n")  # header
        while True:
            result = safe_get_part("Processor", region=region, page=page)
            if not result or not result.parts:
                print("No more results or fetch failed — stopping.")
                break

            print(f"\n=== Page {page}/{result.total_pages} ===")
            for summary in result.parts:
                try:
                    part = client.get_part(summary.url, region=region)
                    name = part.name
                    image = part.image_urls[0] if part.image_urls else ""
                    print(name, image)
                    f.write(name + "," + image + "\n")
                    f.flush()
                    time.sleep(random.uniform(0.5, 1.5))
                except Exception as e:
                    print(f"Error fetching part details: {e}")
                    time.sleep(5)
                except KeyboardInterrupt:
                    print("\nScript stopped by user (Ctrl+C)!")

            if page >= result.total_pages:
                break

            page += 1
            time.sleep(5)

    """
    print(mysql.connector.__version__)

    load_dotenv()
    db = mysql.connector.connect(
        host=os.getenv("IP"),
        port=os.getenv("PORT"),
        user=os.getenv("DB_USER"),
        password=os.getenv("DB_PASSWORD"),
    )

    # Get a cursor
    cur = db.cursor()

    # Execute a query
    cur.execute("SELECT CURDATE()")

    # Fetch one result
    row = cur.fetchone()
    print("Current date is: {0}".format(row[0]))

    # Close connection
    db.close()
    """


if __name__ == "__main__":
    main()
