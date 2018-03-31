#!/usr/bin/env bash

set -o errexit

main() {
    grains "$@"
}

grains(){
    input="$1"

    if [ "$input" ] && [ "$input" -gt 0 ] && [ "$input" -lt 65 ]; then
        #result=$((2 ** ("$input"-1)))
        echo "2^($input-1)"|bc
    else 
        echo "Error: invalid input"
        exit 1
    fi
}

main "$@"
