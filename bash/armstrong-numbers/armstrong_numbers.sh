#!/usr/bin/env bash

set -o errexit

main() {
    if [ "$1" = "is_armstrong" ]; then
        is_armstrong "$@"
    fi
}

is_armstrong(){
    input="$2"
    len=${#input}
    sum=0
    for (( i=len-1; i>=0; i-- ))
    do
        num="${input:$i:1}"
        sum=$(( sum+num ** len ))
    done

    if [ "${input}" -eq "${sum}" ]; then
        echo true
    else
        echo false
        exit 1
    fi
}

main "$@"
