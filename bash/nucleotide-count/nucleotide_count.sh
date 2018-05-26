#!/usr/bin/env bash

set -o errexit

main() {
    func "$@"
}

func(){
    local words="$1"
    local a="${words//[^a|A]}"
    local c="${words//[^c|C]}"
    local g="${words//[^g|G]}"
    local t="${words//[^t|T]}"

    local sum=$((${#a}+${#c}+${#g}+${#t}))
    if [[ $sum -ne ${#words} ]]; then
        echo "Invalid nucleotide in strand" 
        exit 1
    fi

    echo "A: ${#a}"
    echo "C: ${#c}"
    echo "G: ${#g}"
    echo "T: ${#t}"
}

main "$@"
