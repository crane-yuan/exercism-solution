#!/usr/bin/env bash

set -o errexit

main() {
    if [ ! "$2" ]; then
        difference_of_squares "$@"
    elif [ "$2" == "-s" ]; then
        sum_of_square "$@"
    elif [ "$2" == "-S" ]; then
        square_of_sum "$@"
    else
        exit 1
    fi
}

sum_of_square(){
    input="$1"
    sum=0
    for (( i=1; i<=input; i++ ))
    do
        sum=$(( sum+i ** 2 ))
    done
    echo "$sum"
}

square_of_sum(){
    input="$1"
    sum=0
    for (( i=1; i<=input; i++ ))
    do
        sum=$(( sum+i ))
    done
    sum=$(( sum ** 2 ))
    echo "$sum"
}

difference_of_squares(){
    a=$(square_of_sum "$1")
    b=$(sum_of_square "$1")
    result=$((a-b))
    echo "${result}"
}
main "$@"
