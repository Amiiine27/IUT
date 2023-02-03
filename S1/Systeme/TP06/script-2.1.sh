#! /bin/bash

S1=$1
S2=$2

if [[ ${#S1} -gt ${#S2} ]]; 
then
	echo "La deuxième chaine est la plus grande"
	
elif [[ ${#S1} -lt ${#S2} ]]; 
then
		echo "La seconde chaine est la plus grande"

else
	echo "Les arguments sont égaux"
fi
