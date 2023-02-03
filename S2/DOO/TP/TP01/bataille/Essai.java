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
    }


    
}
