package bataille;

/*
 *  La classe Carte modélise les cartes d'un jeu de cartes.
 *
 *  Une carte possède une valeur et une couleur.
 *  Les valeurs sont  représentées par des int entre 2 et 14 (11 pour valet, 12 pour dame, 13 pour roi, 14 pour as).
 *  Les couleurs, représentées par un type String, peuvent être "coeur", "carreau", "trèfle", "pique".
 *
 *  Responsabilités détaillées de la classe Carte :
 *  - créer la nouvelle carte
 *  - dire si la carte est supérieure à une autre carte
 *  - donner une représentation affichable de la carte
 */
public class Carte {

    private int valeur;
    private String couleur;

    public Carte (int v, String c) {
        this.valeur = v;
        this.couleur = c;
    }


    public boolean supérieureA(Carte c) {
        return this.valeur > c.valeur;
    }

    public String toString() {
        String valeurAffichable ;
        if (this.valeur == 14)
            valeurAffichable = "as";
        else if (this.valeur == 11)
            valeurAffichable = "valet";
        else if (this.valeur == 12)
            valeurAffichable = "dame";
        else if (this.valeur == 13)
            valeurAffichable = "roi";
        else
            valeurAffichable = Integer.toString(this.valeur);
        return valeurAffichable + " de " + this.couleur;
    }

}
