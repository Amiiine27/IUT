import java.util.Scanner;

class Produit {

    public static void main(String[] args) {
    
    Scanner calcul =  new Scanner(System.in).useDelimiter("\n");

    double F1, F2, resultat;

    System.out.println("Inserez le premier facteur de votre opération : ");
    F1 = calcul.nextDouble();

    System.out.println("Inserez le second facteur de votre opération : ");
    F2 = calcul.nextDouble();

    resultat = F1*F2;
    
    if (resultat<0) {
        System.out.println("Le signe de votre produit est négatif !");
    }

    else {
        System.out.println("Le signe de votre produit est positif !");
    }

    calcul.close();
}}