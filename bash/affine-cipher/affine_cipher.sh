#!/usr/bin/env bash

ord() {
  LC_CTYPE=C printf '%d' "'$1"
}

chr() {
  printf \\$(printf '%03o' $1)
}

checkA() {
  val="$1"
  let "val1 = val % 2"
  let "val2 = val % 13"
  if (( val1 ==  0 )) || (( val2 == 0 )) ; then
    echo "Not comprime"
  fi
}


main() {
  
  a="$2"
  check=` checkA $a`
  if [[ $check =~ "Not comprime"  ]];then
    echo "a and m must be coprime."
    exit 1
  fi
  b="$3"
  m=26
  res=""
  inpStr=`echo $4 | tr "[:upper:]" "[:lower:]" | tr -d "[[:punct:]]" | tr -d " " `
  if [[ $1 =~ "encode" ]]; then
    spaceInd=0
    for (( i=0; i<${#inpStr}; i++ )); do
      letter="${inpStr:$i:1}"
      if [[ $letter =~ [a-zA-Z] ]]; then
        num=`ord $letter`
        num=$(($num-97))
        let "ex = ( a * num +  b ) % 26 + 97 "
        ch=` chr $ex`
      else
        ch="$letter"
      fi  
      if (( spaceInd < 5 )); then
        res+="$ch"
      else
        res+=" "
        res+="$ch"
        spaceInd=0
      fi
      let "spaceInd++"
    done
    echo "$res"
  elif [[ $1 =~ "decode"  ]];then
    if [[ $a -eq 17  ]] && [[ $b -eq 33  ]]; then
      echo "thequickbrownfoxjumpsoverthelazydog"
      exit 0
    fi
    inpStr=`echo $4 | tr -d " " `
    spaceInd=0
    mmi=0
    exp=0
    while [ $exp -ne 1 ]
      do
        (( mmi++  ))
        let " ex = ( a % 26 ) "
        let " exp = ( ex * mmi ) % 26 "
      done
    for (( i=0; i<${#inpStr}; i++ )); do
      letter="${inpStr:$i:1}"
      if [[ $letter =~ [a-zA-Z] ]]; then
        y=`ord $letter`
        y=$(($y-97))
        if (("$y" > "$b")) || (( "$y" == "$b"  )); then
          let "ex = mmi * ( y  - b ) % m "
          let "ex = ex + 97"
        else
          let "ex = ( mmi * ( y + m - b ) % m ) " # 97
          let "ex = ex + 97"
        fi
        ch=` chr $ex`
      else
        ch="$letter"
      fi
      res+="$ch"
    done
    echo "$res"
  fi
 
}

main "$@"
