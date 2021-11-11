#!/bin/bash
arr=(10 30 999 9 25 12 99)
len=${#arr[@]}
echo "len : $len"
maxSum=0
maxNumber=0
#brr=$len
# shellcheck disable=SC2068
for i in ${arr[@]}
do
    sum=0
    k=$i
    while [ $k -gt 0 ]
    do
        mod=`expr $k % 10`    #It will split each digits
        sum=`expr $sum + $mod`  #Add each digit to sum
        k=`expr $k / 10`    #divide num by 10.
    done

    if [ "$sum" -gt $maxSum ]
    then
            maxSum=$sum
            maxNumber=$i
    fi
done
echo " maxNumber : $maxNumber"

