#!bin/ksh
echo -n "Enter purchase amount : "
read amount

if [ $amount -lt 1500 ]
then
   echo "10% discount "
   discount=$(( $amount  * 10 / 100 )) # 10% discount
   echo "1.5% tax"
   tax=$(( $amount * 1.5 / 100 )) # 1.5% tax
elif [ $amount -gt 1500 ]
then
   echo "20% discount"
   discount=$(( $amount  * 20 / 100 )) # 20% discount
   echo "3% tax"
   tax=$(( $amount * 3 / 100 )) # 3% tax
fi
# how much user need to pay? after discount
pay=$(( $amount - $discount ))
payableAmount=$(($pay + $tax ))
echo "You need to pay INR. $payableAmount"

