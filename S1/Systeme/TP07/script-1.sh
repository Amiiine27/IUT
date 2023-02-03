#! /bin/bash


[ $1 -eq $1 ] 2> /dev/null

if [ $? -ne 0 ]
then
echo “ERREUR : $1 n’est pas un nombre”
exit 1
fi

[ $2 -eq $2 ] 2>> /dev/null

if [ $? -ne 0 ]
then
echo “ERREUR : $2 n’est pas un nombre”
exit 2
fi
somme=0
	for i in $(seq $1 $2);
	do 
		somme=`expr $somme + $i`
		
	done
echo $somme