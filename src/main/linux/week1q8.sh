#!/bin/bash
echo "Enter directory path for delete older file : "
read directory_path
if [ -d $diretory_path ]
then
      echo "Enter date : "
      read date
      echo "Do you want to delete older file(Yes/No) : "
      read option
      if [[ $option == Yes ]] || [ $option == yes ]
      then
            find $path -type f ! -newermt $date -exec rm -f {} \;
      fi
fi





