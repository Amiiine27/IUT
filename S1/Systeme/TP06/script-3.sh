#! /bin/bash

mkdir $1

read -p "Que voulez vous inserer dans le fichier $1 ? " inser
	echo >> "$inser"

while [[ -n inser ]]; 
do
	read -p "Que voulez vous inserer dans le fichier $1 ? " inser
	echo "----------------"
	more $1
	echo "---------------"
	echo >> "$inser" 
done
