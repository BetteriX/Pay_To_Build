#!/usr/bin/env python3

import mysql.connector
from mysql.connector import Error
from dotenv import load_dotenv
import os


def list_databases():
    load_dotenv()

    host = os.getenv("IP")
    port = int(os.getenv("PORT", 3306))
    user = os.getenv("DB_USER")
    password = os.getenv("DB_PASSWORD")

    # Connect to MySQL without specifying a database
    db = mysql.connector.connect(host=host, port=port, user=user, password=password)

    cur = db.cursor()

    # Select all rows from the table
    cur.execute("SELECT * FROM ptb.cpu_test")  # replace with your table name

    # Fetch all rows
    rows = cur.fetchall()

    # Print column names
    columns = [desc[0] for desc in cur.description]
    print("\t".join(columns))

    # Print each row
    for row in rows:
        print("\t".join(str(cell) for cell in row))

    db.close()


if __name__ == "__main__":
    list_databases()
