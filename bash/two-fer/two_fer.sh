#!/usr/bin/env bash

set -o errexit

main() {
    two_fer "$@"
}

two_fer(){
    input="$*"
    words="One for ${input:-you}, one for me."
    echo "$words"
}

main "$@"
