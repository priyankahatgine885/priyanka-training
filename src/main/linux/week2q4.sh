#!/bin/bash
echo -n "Enter location for count directory or file : "
read LOCATION
echo "Enter user name : "
read user_name
user_name_ofSystem=$(users)
echo "$user"
for path in $LOCATION
do
    if [ $user_name == $user_name_ofSystem ]
    then
          echo "File count: "
          sudo find $path -maxdepth 1 -type f -user $user_name_ofSystem  | wc -l
          echo "Directory count: "
          sudo find $path -maxdepth 1 -type d -user $user_name_ofSystem  | wc -l
    else
          echo "User name not exist"
    fi
done

