import java.util.Scanner;

class Maths{
    public static void main(String[] args) {
        Scanner saisie = new Scanner(System.in).useDelimiter("\n");

        double PI = 3.14;
        double r, circ, aire;

        System.out.println("Combien mesure votre rayon ? ");
        r = saisie.nextDouble();

        circ = (2*PI*r);
        System.out.println("La circonférence de ce cercle est de " + circ + "cm");

        aire = (PI*r*r);
        System.out.println("L'aire de ce cercle est de " + aire + "cm");

    }
}