#!/usr/bin/env bash

set -o errexit

main() {
    func "$@"
}

func(){
    input="$1"
    possibles="$2"

    out=""

    in_counts="$(echo $input | tr '[:upper:]' '[:lower:]' | fold -w1 | sort | uniq -c)"
    for possible in $possibles
    do
        p_counts="$(echo $possible | tr '[:upper:]' '[:lower:]' | fold -w1 | sort | uniq -c)"
        if test "$in_counts" = "$p_counts" -a "$(echo $input | tr '[:upper:]' '[:lower:]')" != "$(echo $possible | tr '[:upper:]' '[:lower:]')"
        then
            out="${out} ${possible}"
        fi
    done

    echo ${out# } #strip leading spaces
}

main "$@"
