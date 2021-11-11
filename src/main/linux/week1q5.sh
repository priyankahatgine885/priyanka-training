#!/bin/bash
echo "Enter first string is: "
read fString
echo "Enter second string is: "
read sString
echo "First string : $fString"
echo "Second string : $sString"
i=0
while [ $i -ne ${#fString} ]
do
    ch=${fString:$i:1}
    if [[ $result != *$ch* && $sString == *$ch* ]]
    then
      result=$result$ch
    fi
    ((i++))
done
echo $result
