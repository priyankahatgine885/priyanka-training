#!/bin/bash
echo -n "Enter location : "
 read LOCATION
for path in $LOCATION
do
       echo "File count: "
       #sudo find $path -maxdepth 1 -type f -user $user_name  | wc -l
       find $path -maxdepth 1 -type f | wc -l
        #FILECOUNT=$(find $LOCATION -type f | wc -l)
       echo "Directory count: "
       find $path -maxdepth 1 -type d | wc -l
       #DIRCOUNT=$(find $LOCATION -type d | wc -l)
done

