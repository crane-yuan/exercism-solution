#!/usr/bin/env bash

set -o errexit

main() {
    func "$@"
}

func(){
    # mac env
    local timestamp=$(gdate -d"$1" +"%s")
    local start=$(($timestamp+1000000000))

    local finish=$(gdate -d "@$start" -u)

    echo $finish
}

main "$@"
