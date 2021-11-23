#!/bin/bash
echo "First string : $1"
echo "Second string : $2"
i=0
while [ $i -ne ${#1} ]
do
    ch=${1:$i:1}
    if [[ $result != *$ch* && $2 == *$ch* ]]
    then
      result=$result$ch
    fi
    ((i++))
done
echo "Common letters in both string :" $result

