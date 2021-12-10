#!/bin/bash
#echo "Enter first string is: "
#read fString
#echo "Enter second string is: "
#read sString
#echo "First string before swaping : $fString"
#echo "Second string before swaping : $sString"
#for ((i=0; i<${#fString};i++))
#do
        arr[$i]=${fString:$i:1}
        if['expr $i / 2' != 0]
                j='expr $i + 2'
                temp=arr[$i]
                arr[$i]=arr[$j]
                arr[$j]=temp
done
echo ${arr[@]}
t=$fString
fString=$sString
sString=$t
#echo "First string after swaping : $fString"
#echo "Second string after swaping : $sString"
