#!/usr/bin/env bash

set -o errexit

main() {
    error_handle "$@"
}

error_handle(){
    if [ $# -gt 1 ]; then
        exit 1
    elif [ $# -lt 1 ]; then
        echo "Usage: ./error_handling <greetee>"
        exit 1
    else
        echo "Hello, $1"
    fi
}

main "$@"
