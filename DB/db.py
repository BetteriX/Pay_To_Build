#!/usr/bin/env python3

import mysql.connector
from mysql.connector import Error
import os
import csv
from dotenv import load_dotenv

load_dotenv()

# MySQL connection info (pl. .env-ből vagy direkt)
host = os.getenv("IP")
port = int(os.getenv("PORT", 3306))
user = os.getenv("DB_USER")
password = os.getenv("DB_PASSWORD")

conn = mysql.connector.connect(
    host=host,
    port=port,
    user=user,
    password=password,
    database="ptb",
    charset="utf8",
    use_unicode=True,
)

cursor = conn.cursor()


def load_images_from_csv(category_name: str):
    file_path = f"new_data/{category_name}.csv"
    if not os.path.exists(file_path):
        print(f"CSV file for {category_name} not found, skipping.")
        return

    with open(file_path, newline="", encoding="utf-8") as csvfile:
        reader = csv.DictReader(csvfile)
        for row in reader:
            name = row["name"]
            image = row["image"]

            sql = f"UPDATE `{category_name}` SET image = %s WHERE name = %s"
            cursor.execute(sql, (image, name))


def main():
    categories = [
        "cpu",
        "memory",
        "motherboard",
        "internal-hard-drive",
        "video-card",
        "ups",
        "case",
        "cpu-cooler",
    ]

    for category in categories:
        load_images_from_csv(category)

    conn.commit()
    cursor.close()
    conn.close()
    print("All images updated successfully!")


if __name__ == "__main__":
    main()
