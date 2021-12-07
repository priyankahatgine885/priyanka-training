#!/bin/bash
if java -version;
then
      echo "Java is installed"
else
      echo "java is not installed"
      sudo apt update
      sudo apt install oracle-java11-installer
      java -version
      echo "java is installed on your system"
fi
if  [[ -n "$JAVA_HOME" ]] && [[ -x "$JAVA_HOME/bin" ]];
then
             echo "found java executable in JAVA_HOME"
             echo "JAVA_HOME : " $JAVA_HOME
             echo "Path : " $PATH
else
            echo "JAVA_HOME  env variable is not set"
            java_path= which java
            echo "$java_path"
            export JAVA_HOME=$java_path
            export PATH=$JAVA_HOME/bin
            echo "$JAVA_HOME"
            echo "$PATH"
fi