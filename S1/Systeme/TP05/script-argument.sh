#! /bin/bash

echo “Script $0 – Nombre d’arguments : $#”
echo “Bonjour $1”
echo “Vous avez demandé le listing du répertoire $2”
cd $2
ls
echo “Le script est à présent terminé” 
