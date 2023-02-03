#! /bin/bash

echo “Script $0 – Nombre d’arguments : $#”
echo “Bonjour, quel est votre nom ?”
read nom
echo “Bonjour $nom, quel répertoire souhaitez-vous lister aujourd’hui ?”
read repertoire
echo “Vous avez demandé le listing du répertoire $repertoire”
cd $repertoire
ls
echo “Le script est à présent terminé”
