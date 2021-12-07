#!/bin/bash
read -p "Enter directory name(Source)for archive: " directory_names
for directory in $directory_names
do
        echo "Enter archive file name(Destination) : $1"
        read archive_fileName
        tar cfv $archive_fileName.tar $directory
        echo "Select option : gzip or bzip2 for create compress tar archive file : $2"
        read compress_tarFile
        if [[ $compress_tarFile =  gzip ]]
        then
                tar cvfz $archive_fileName.tgz $directory
        else
                tar cvfj $archive_fileName.tar.bz2 $directory
        fi
done
