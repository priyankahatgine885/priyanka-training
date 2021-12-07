#!/bin/bash
#function sleeper

function sleeper()
{                            # define a function that...
    sleep $1                 # sleeps for duration of its argument in seconds
    echo $1                  # prints its argument to the console
}
while [ -n "$1" ]
do
    sleeper $1 &
    shift
done
wait
