#!/usr/bin/env bash

set -o errexit

main() {
    func "$@"
}

func(){
    "$@"
}

za="$(echo {z..a} | tr -d ' ')"
encode () {
    local clean_string=$(echo "$1" | tr -dc '[:alnum:]\n\r' | tr '[:upper:]' '[:lower:]')
    local converted_string=$(echo "$clean_string" | tr "a-z" "$za")
    echo "$converted_string" | sed 's/.\{5\}/& /g' | awk '{$1=$1};1'
}

decode () {
    local clean_string=$(echo "$1" | tr -d '[:space:]')
    echo $clean_string | tr "$za" "a-z"
}
main "$@"
