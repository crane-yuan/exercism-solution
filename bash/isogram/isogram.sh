#!/usr/bin/env bash

set -o errexit

main() {
    func "$@"
}

func(){
    word=`echo $* | tr -d ' -' | tr '[:upper:]' '[:lower:]'`
    for letter in {a..z};do
        word="${word/$letter/}"
    done
    
    if [ -z $word ] ; then
        echo 'true'
    else
        echo 'false'
    fi
}

main "$@"
