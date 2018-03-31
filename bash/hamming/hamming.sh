#!/usr/bin/env bash

set -o errexit

main() {
    diff "$@"
}

diff(){
    if [ $# -eq 2 ]; then
        a="$1"
        b="$2"
        len_a=${#a}
        len_b=${#b}
        #echo "$a $b $len_a $len_b"
        if [ "$len_a" -eq "$len_b" ]; then
            sum=0
            for (( i=0; i<len_a; i++ ))
            do
                char_a="${a:$i:1}"
                char_b="${b:$i:1}"
                if [ "$char_a" != "$char_b" ]; then
                    sum=$((sum+1))
                fi
            done
            echo "$sum"
        else
            echo "The two strands must have the same length."
            exit 1
        fi
    else
        echo "Usage: hamming.sh <string1> <string2>"
        exit 1
    fi
}

main "$@"
