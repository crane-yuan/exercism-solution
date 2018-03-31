#!/usr/bin/env bash

set -o errexit

main() {
    scrabble_score "$@"
}

scrabble_score(){
    input="${1^^}"
    declare -A POINTS_MAP
    one_point="A, E, I, O, U, L, N, R, S, T"
    two_point="D, G"
    three_point="B, C, M, P"
    four_point="F, H, V, W, Y"
    five_point="K"
    eight_point="J, X"
    ten_point="Q, Z"

    OIFS="$IFS"
    IFS=', '
    read -ra one_points<<< "${one_point}"
    read -ra two_points<<< "${two_point}"
    read -ra three_points<<< "${three_point}"
    read -ra four_points<<< "${four_point}"
    read -ra five_points<<< "${five_point}"
    read -ra eight_points<<< "${eight_point}"
    read -ra ten_points<<< "${ten_point}"

    for i in "${one_points[@]}"
    do
        POINTS_MAP[$i]=1
    done

    for i in "${two_points[@]}"
    do
        POINTS_MAP[$i]=2
    done

    for i in "${three_points[@]}"
    do
        POINTS_MAP[$i]=3
    done

    for i in "${four_points[@]}"
    do
        POINTS_MAP[$i]=4
    done

    for i in "${five_points[@]}"
    do
        POINTS_MAP[$i]=5
    done

    for i in "${eight_points[@]}"
    do
        POINTS_MAP[$i]=8
    done

    for i in "${ten_points[@]}"
    do
        POINTS_MAP[$i]=10
    done

    IFS="$OIFS"
    if [ "$input" ]; then
        sum=0
        for x in $(echo ${input^^} | grep -o .); do
            sum=$(($sum+${POINTS_MAP[${x}]}))
        done
        echo "$sum"
    else
        echo 0
    fi
}

main "$@"
