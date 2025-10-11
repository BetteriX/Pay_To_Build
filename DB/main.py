#!/usr/bin/env python3

import os
from dotenv import load_dotenv
import pypartpicker
import mysql.connector


def main():
    # pcpp = pypartpicker.Client()
    # part = pcpp.get_part("https://pcpartpicker.com/product/fN88TW")

    # for spec, value in part.specs.items():
    #    print(f"{spec}: {value}")

    # print(part.cheapest_price)
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


if __name__ == "__main__":
    main()
