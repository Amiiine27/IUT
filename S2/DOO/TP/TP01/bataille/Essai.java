package bataille;

import java.util.ArrayList;

public class Essai {

    public static void main(String[] args) {
        Carte C1, C2, C3;
        C1 = new Carte(10, "coeur");
        C2 = new Carte(7, "trèfle");

        System.out.println("C1 = " + C1.toString());
        System.out.println("C2 = " + C2.toString());

        ArrayList<Carte> paquetTrié;

        paquetTrié = FabriqueDeJeuxDe32Cartes.créerJeu32DansOrdre();
        System.out.println(paquetTrié);

        ArrayList<Carte> paquetBattu;

        paquetBattu = FabriqueDeJeuxDe32Cartes.créerJeu32Battu();
        System.out.println(paquetBattu);

        Carte valtri = paquetTrié.get(0), valbat = paquetBattu.get(0);

        System.out.println(valtri.supérieureA(valbat));

        System.out.println("----------------------");

        if (paquetBattu.get(0).supérieureA(paquetBattu.get(1))) System.out.println("LA première ("+paquetBattu.get(0)+") est plus grande que la deuxième ("+paquetBattu.get(1)+")");
        else if (paquetBattu.get(1).supérieureA(paquetBattu.get(0))) System.out.println("LA deuxième ("+C2+") est plus grande que la première ("+C1+")");
        else System.out.println("Les deux cartes ont la même valeur");


        System.out.println("creer le joueur");

        Joueur joueur_essai;
        joueur_essai = new Joueur("Amine");
        System.out.println(joueur_essai);
    }


    
}
