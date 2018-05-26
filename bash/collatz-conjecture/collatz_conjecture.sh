#!/usr/bin/env bash

set -o errexit

main() {
    func "$@"
}

func(){
    local number="${1}"
    local step=0
    if [[ $number -lt 1 ]]; then
        echo "Error: Only positive numbers are allowed"
        exit 1;
    fi
    while [ $number -ne 1 ]
    do
        if (( $number % 2 )); then
            number=$(($number * 3 + 1))
        else
            number=$(($number/2))
        fi
        step=$(($step+1))
    done
    echo "$step"
}

main "$@"
