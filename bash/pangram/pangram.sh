#!/usr/bin/env bash

set -o errexit

main() {
    func "$@"
}

func(){
    input=$1
    #delete non-letters then lowercase, count number of unique letters
    letter_count=$(echo $input | tr -dc [:alpha:] | tr '[:upper:]' '[:lower:]' | fold -w1 | sort -u | wc -l)

    test $letter_count -eq 26
}

main "$@"
