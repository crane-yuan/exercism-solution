#!/usr/bin/env bash

set -o errexit

main() {
    func "$@"
}

func(){
    input=$1
    # detect invalid letters
    letter=$(echo $input | tr -d 'GCTA')

    if [ -z $letter ]; then
        echo $input | tr 'GCTA' 'CGAU'
    else
        echo 'Invalid nucleotide detected.'
        exit 1
    fi
}

main "$@"
