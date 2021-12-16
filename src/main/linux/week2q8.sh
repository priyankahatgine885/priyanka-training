#! /bin/bash
echo "Enter port number to check process is running on specified port :"
read port_number
if lsof -Pi :$port_number -sTCP:LISTEN -t >/dev/null ;
then
      echo "process is running on specified port"
      echo "Do you want to kill this process(Y/N) :"
      read option
      if [ $option == Y ] || [ $option == y ]
      then
            fuser -k $port_number/tcp
            echo "This process is successfully killed"
      fi
else
      echo "process is not running on specified port"
fi
