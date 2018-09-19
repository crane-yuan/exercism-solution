#!/usr/bin/env bash

names=`ls -d */ | cut -f1 -d'/'`

#echo ${names}

for name in ${names}
do
    #echo $name
    `exercism download --exercise=${name} --track=java`
done
