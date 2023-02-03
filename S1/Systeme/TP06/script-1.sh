#! /bin/bash

if [ $# -ne 1 ]
then
	echo “SYNTAXE : $0 répertoire”
else
	echo ‘ls $1’
	echo “ls $1”
	echo `ls $1`
fi
