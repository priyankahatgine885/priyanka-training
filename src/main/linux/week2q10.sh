#!/bin/bash
echo "IP of system is : $(arp -a | awk '{print $2 }' | tr -d "()") "
echo "MAC Address of system is: $(ip link show enp0s31f6 | awk '/ether/ {print $2}')"
