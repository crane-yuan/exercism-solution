#!/usr/bin/env bash

set -o errexit

main() {
    func "$@"
}

func(){
    local input="$1"
    echo "$input" \
        | tr '[:upper:]' '[:lower:]' \
        | tr ', ' '\n' \
        | tr -d '.:&@$%^!' \
        | tr -s '\n' \
        | sort \
        | uniq -c \
        | awk '{printf("%s: %s\n",$2,$1)}'

    exit $?
}

main "$@"
