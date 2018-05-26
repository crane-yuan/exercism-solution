#!/usr/bin/env bash

set -o errexit

main() {
    func "$@"
}

func(){
    local correct_pattern="^1?[2-9][0-9]{2}[2-9][0-9]{6}$"
    local input="$1"
    local result=${input//[^0-9]/""}

    if [[ ! $result =~ $correct_pattern ]]; then
        echo "Invalid number.  [1]NXX-NXX-XXXX N=2-9, X=0-9" 
        exit 1
    fi

    echo "${result: -10}"
}

main "$@"
