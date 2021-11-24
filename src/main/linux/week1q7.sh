#!/bin/bash
DIRECTORY=$1
i=$( (find $HOME -type d -name $DIRECTORY) )
if [[ -d "$i" ]]
then
        echo "DIRECTORY exists on your filesystem."
        FILES="$a/*"
        for a in $FILES
        do
                echo "$a"
                #stat $a

        done
        echo "Timestamp of each file in directory is updated"
else
        echo "$DIRECTORY not exists on your filesyatem."

        echo "Enter file name : "
        read fileName
        mkdir $DIRECTORY && touch $DIRECTORY/$fileName
        echo "Hello world" > $fileName
        #cat $fileName
fi
