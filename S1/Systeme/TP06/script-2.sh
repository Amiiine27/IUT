#! /bin/bash
if [[ $1 -gt $2 ]]; 
then
	echo "Le premier argument ($1) est le plus grand"
elif [[ $1 -lt $2 ]]; 
then
		echo "Le deuxieme argument ($2) est le plus grand"

else
	echo "Les arguments sont égaux"
fi
