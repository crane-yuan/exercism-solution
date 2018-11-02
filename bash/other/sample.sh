#!/bin/bash

var="helloworld!"

echo "$var"

# String substitution in variables
echo "${var/l/a}"

# Substring from a variable
echo "${var:1:5}"

# Default value for variable
var2=""
echo ${var2:-"DefaultValueIfFooIsMissingOrEmpty"}
var3=${var2:-"DefaultValueIfFooIsMissingOrEmpty"}
echo "$var3"

# Brace Expansion { }
# Used to generate arbitrary strings
echo {1..10}
echo {a..z}

# Builtin variables:
# There are some useful builtin variables, like
echo "Last program's return value: $?"
echo "Script's PID: $$"
echo "Number of arguments passed to script: $#"
echo "All arguments passed to script: $*"
echo "Script's arguments separated into different variables: $1 $2..."

echo "I'm in $(pwd)" # execs `pwd` and interpolates output
echo "I'm in $PWD" # interpolates the variable

clear

# Reading a value from input:
echo "What's your name?"
Name="tom"
#read -r Name # Note that we didn't need to declare a new variable
echo "Hello, $Name!"

# We have the usual if structure:
# use 'man test' for more info about conditionals
if [ "$Name" != "$USER" ]
then
    echo "Your name isn't your username"
else
    echo "Your name is your username"
fi

# There is also conditional execution
echo "Always executed" || echo "Only executed if first command fails"
echo "Always executed" && echo "Only executed if first command does NOT fail"

# Expressions are denoted with the following format:
echo $(( 10 + 5 ))

# Run a command and print its file descriptor (e.g. /dev/fd/123)
# see: man fd
echo <(echo "#helloworld")

# Commands can be substituted within other commands using $( ):
# The following command displays the number of files and directories in the
# current directory.
echo "There are $(ls | wc -l) items here."

# Bash uses a case statement that works similarly to switch in Java and C++:
Variable="1"
case "$Variable" in
    #List patterns for the conditions you want to meet
    0) echo "There is a zero.";;
    1) echo "There is a one.";;
    *) echo "It is not null.";;
esac

# for loops iterate for as many arguments given:
# The contents of $Variable is printed three times.
for Variable in {1..3}
do
    echo "$Variable"
done

# Or write it the "traditional for loop" way:
for ((a=1; a <= 3; a++))
do
    echo $a
done

# ..or the output from a command
# This will cat the output from ls.
for Output in $(find . -maxdepth 1 -type f)
do
    #cat "$Output"
    echo "$Output"
done
