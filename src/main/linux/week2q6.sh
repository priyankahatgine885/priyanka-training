#! /bin/bash
echo "Enter the file name to be extract : "
read filename
if [ -f $filename ]
then
        case $filename in
                *.tar.bz2) tar xvjf $filename ;;
                *.tar.gz)  tar xvzf $filename ;;
                *.bz2)     tar bunzip2 $filename ;;
                *.gz)      tar gunzip $filename ;;
                *)         echo "can't extract";;
        esac
else
        echo "Enter correct file name...."
fi