#!/usr/bin/env bash

set -o errexit

main() {
    func "$@"
}

func(){
    if [[ $# -eq 0 ]]; then
        say "Fine. Be that way!"
    fi
    local input="$(printf %b "${1}")"
    local input="${input//[[:space:]]/}"

    if [[ "" == "${input}" ]]; then
        say "Fine. Be that way!"
    fi
    if [[ "$input" == *[[:upper:]]* ]] && [[ "$input" != *[[:lower:]]* ]]; then
        say "Whoa, chill out!"
    fi
    if [[ "${input: -1}" == "?" ]]; then
        say "Sure."
    fi
    echo "Whatever."
}

say(){
    local msg="${1}"
    echo "${msg}"
    exit 0
}
main "$@"
