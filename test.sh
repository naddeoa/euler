#!/bin/sh

MAIN=Main

echo "Testing with 100 edge Eulerian circuit"
java $MAIN < input/100.txt
echo
echo "Testing with 1000 edge Eulerian circuit"
java $MAIN < input/1000.txt
echo
echo "Testing with 5000 edge Eulerian circuit"
java $MAIN < input/5000.txt
echo
echo "Testing with 10000 edge Eulerian circuit"
java $MAIN < input/10000.txt
echo
echo "Testing with 20000 edge Eulerian circuit"
java $MAIN < input/20000.txt
echo
echo "Testing with 40000 edge Eulerian circuit"
java $MAIN < input/40000.txt
