// written in bash
/* #!/bin/bash

input=$1
totalNum=0;
grep -oe "mul\(([0-9]*,[0-9]*)\)" $input | while IFS= read -r line; do
        numbers=$(echo "$line" | grep -oe "[0-9]*,[0-9]*")
        numberOne=$(echo "$numbers" | cut -d "," -f 1)
        numberTwo=$(echo "$numbers" | cut -d "," -f 2)
        totalNum=$(($totalNum + $numberOne * $numberTwo))
        echo $totalNum
done
echo $totalNum
*/