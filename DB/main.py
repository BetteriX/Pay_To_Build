#!/usr/bin/env python3
import pypartpicker


def main():
    pcpp = pypartpicker.Client()
    part = pcpp.get_part("https://pcpartpicker.com/product/fN88TW")

    for spec, value in part.specs.items():
        print(f"{spec}: {value}")

    print(part.cheapest_price)


if __name__ == "__main__":
    main()
