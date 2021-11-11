#!/bin/bash
echo "Enter a file name : "
# shellcheck disable=SC2162
read fname1
if [ -f "$fname1" ]; then
find . -type f -name "$fname1"
else
echo "Error : $fname1 does not exist"
fi

