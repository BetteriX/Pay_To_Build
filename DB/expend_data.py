#!/usr/bin/env python3

import pandas as pd
from fuzzywuzzy import process


def merge(name: str):
    # Load your datasets
    cases_df = pd.read_csv(f"data/{name}.csv")  # first dataset
    images_df = pd.read_csv(f"img/{name}.csv")  # second dataset

    # Exact match merge
    merged_df = pd.merge(cases_df, images_df, on="name", how="left")

    def get_best_match(name, choices, threshold=80):
        match, score = process.extractOne(name, choices)
        if score >= threshold:
            return match
        return None

    missing_mask = merged_df["image"].isnull()
    for idx in merged_df[missing_mask].index:
        case_name = merged_df.loc[idx, "name"]
        best_match = get_best_match(case_name, images_df["name"].tolist())
        if best_match:
            merged_df.loc[idx, "image"] = images_df.loc[
                images_df["name"] == best_match, "image"
            ].values[0]

    # Save the result
    merged_df.to_csv(f"{name}/case.csv", index=False)


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
        merge(category)


if __name__ == "__main__":
    main()
