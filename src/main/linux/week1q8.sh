#!/bin/bash
echo "Enter directory or file path for delete older file : "
read path

echo "Enter date : "
read date

find $path -type f ! -newermt $date -exec rm -f {} \;