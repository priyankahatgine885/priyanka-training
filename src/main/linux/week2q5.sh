#!/bin/bash
#read -p "Enter directory name for archive: " directory_names
echo "Enter source (directory) name for archive: "
read sourcedirectory
SOURCE="$HOME/$sourcedirectory"
echo "$directory"
echo "Enter archive file  name for to create an archive file : "
read BACKUP_DIR
tar cfv $BACKUP_DIR.tar -P $SOURCE

echo "Select option : gzip or bzip2 for create compress tar archive file : "
read compress_tarFile
if [[ $compress_tarFile ==  gzip ]]
then
      tar cvfz $BACKUP_DIR.tar.gz -P $SOURCE
else
      tar cvfj $BACKUP_DIR.tar.bz2 -P $SOURCE
fi


