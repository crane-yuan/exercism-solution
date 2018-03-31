#!/usr/bin/env bash

set -o errexit

main() {
    func "$@"
}

func(){
    input="$*"
    reverse=""
    len=${#input}
    for (( i=len-1; i>=0; i-- ))
    do
        reverse="$reverse${input:$i:1}"
        echo "$reverse"
    done
    echo "$reverse"
}

main "$@"
