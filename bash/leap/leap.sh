#!/usr/bin/env bash

set -o errexit

main() {
    func "$@"
}

func(){
    input="$*"
    if [ "$#" -ne 1 ] || ! [ "$input" -eq "$input" >& /dev/null ]; then
        echo 'Usage: leap.sh <year>'
        exit 1
   else
        year=$input
       (( !(year % 4) && ( year % 100 || !(year % 400) ) )) &&
           echo "true" || echo "false"
    fi
}

main "$@"
