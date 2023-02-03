#include <stdio.h>

int echange(int a, int b){
	printf("%d %d\n", a, b);
	int pivot;
	pivot=a;
	a=b;
	b=pivot;
	printf("%d %d\n", a, b);
	return 1;
}

int decalage(void){
	int compteur=0;
	unsigned int a=1;

	printf("\n|=====> UNISGNED INT\n");

	while (a!=0){
		printf("a = %d et ", a);
		a= a<<1;
		compteur++;
		printf("Il y a %d dans %d après le décalage\n", compteur, a);
	}

	printf("\n|=====> UNISGNED SHORT INT\n");
	unsigned short int b=1;
	compteur = 0;

	while (b!=0){
		printf("b = %d et ", b);
		b= b<<1;
		compteur++;
		printf("Il y a %d dans %d après le décalage\n", compteur, b);
	}
	
	printf("Saisir un nombre eniter signé \n");
	
	int a=1;
	int c;
	scanf("%d", c);
	
	i=0;
	for (i=0; i<compteur; c++){
		printf("%d", a&c);
		c=c>>1;
	}

	return compteur;
}



int main(void){
	// echange(1,2);
	decalage();
}


		












