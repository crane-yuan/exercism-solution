#!/usr/bin/env bash

set -o errexit

main() {
    func "$@"
}

func(){
    input=$1
    letter=$(echo $input | tr -s ' -' '\n' | cut -c1 | tr -dc [:alpha:] | tr '[:lower:]' '[:upper:]')
    echo $letter
}

main "$@"
