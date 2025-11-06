#!/usr/bin/env python3

import subprocess
import string
import random
import re
import socket
import time


def get_random_mac_address():
    """Generate and return a MAC address in the format of Linux"""
    # get the hexdigits uppercased
    uppercased_hexdigits = "".join(set(string.hexdigits.upper()))
    # 2nd character must be 0, 2, 4, 6, 8, A, C, or E
    mac = ""
    for i in range(6):
        for j in range(2):
            if i == 0:
                mac += random.choice("02468ACE")
            else:
                mac += random.choice(uppercased_hexdigits)
        mac += ":"
    return mac.strip(":")


def get_current_mac_address(iface):
    output = subprocess.check_output(f"ifconfig {iface}", shell=True).decode()
    return re.search("ether (.+) ", output).group().split()[1].strip()


def change_mac_address(iface, new_mac_address):
    subprocess.check_output(f"ifconfig {iface} down", shell=True)
    subprocess.check_output(f"ifconfig {iface} hw ether {new_mac_address}", shell=True)
    subprocess.check_output(f"ifconfig {iface} up", shell=True)


def reconnect_wifi(interface: str, ssid: str):
    """Reconnect to a saved Wi-Fi network (SSID) after MAC change."""
    print(f"[*] Reconnecting Wi-Fi to saved network '{ssid}'...")

    # Disconnect from current Wi-Fi
    subprocess.run(["nmcli", "device", "disconnect", interface], check=False)
    time.sleep(2)

    # Reconnect to saved SSID
    cmd = ["nmcli", "device", "wifi", "connect", ssid, "ifname", interface]
    result = subprocess.run(cmd, capture_output=True, text=True)
    print(result.stdout or result.stderr)

    # Wait until Internet is back
    for i in range(20):
        try:
            socket.create_connection(("8.8.8.8", 53), timeout=2)
            print(f"[+] Connected to '{ssid}' and Internet is available.")
            return True
        except OSError:
            time.sleep(1)

    print(f"[!] Failed to connect to '{ssid}' after 20 seconds.")
    return False
