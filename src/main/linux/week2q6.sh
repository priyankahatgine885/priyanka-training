#!/bin/bash
read -p "Enter compress file name to extract : " file
echo "$file"
tar -xvf $file