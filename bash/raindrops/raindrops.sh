#!/usr/bin/env bash

set -o errexit

main() {
    func "$@"
}

func(){
    num="$1"
    flag=""
    if [ $(($num % 3)) -eq 0 ]; then
        flag=1
        echo -n "Pling"
    fi
    if [ $(($num % 5)) -eq 0 ]; then
        flag=1
        echo -n "Plang"
    fi
    if [ $(($num % 7)) -eq 0 ]; then
        flag=1
        echo -n "Plong"
    fi

    if [ -z $flag ]; then
        echo $num
    fi
}

main "$@"
