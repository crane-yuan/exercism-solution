#!/usr/bin/env bash

set -o errexit

main() {
    func "$@"
}

func(){
    triangle_type=$1
    s1=$2
    s2=$3
    s3=$4
    if ! valid_triangle $s1 $s2 $s3; then
        output 1
    fi
    $triangle_type $s1 $s2 $s3 && exit 0 || exit 1
}
valid_triangle() {
    assert "$1 == 0" || assert "$2 == 0" || assert "$3 == 0" && return 1
    assert "$1 + $2 <= $3" || assert "$1 + $3 <= $2" || assert "$2 + $3 <= $1" && return 1

    return 0
}

assert(){
    [[ $(echo $1 | bc -l) -eq 1 ]]
}
output() {
    exit_code=$1

    if [ $exit_code -eq 0 ]; then
        echo "true"
    else
        echo "false"
    fi

    exit $exit_code
}
equilateral() {
    assert "$1 == $2" && assert "$1 == $3"

    output $?
}

isosceles() {
    assert "$1 == $2" || assert "$1 == $3" || assert "$2 == $3"

    output $?
}

scalene() {
    assert "$1 != $2" && assert "$1 != $3" && assert "$2 != $3"

    output $?
}
main "$@"
