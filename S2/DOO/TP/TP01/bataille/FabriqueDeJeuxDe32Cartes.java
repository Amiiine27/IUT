package bataille;
import java.util.ArrayList;
import java.util.Collections;

/*
 * La classe FabriqueDeJeuxDe32Cartes met à disposition des méthodes statiques permettant de créer et distribuer des jeux de 32 cartes.
 */
public class FabriqueDeJeuxDe32Cartes {

    final static String[] COULEURS = {"coeur", "carreau", "trèfle", "pique"};

    /*
     * Retourne un jeu trié de 32 cartes.
     */
    public static ArrayList<Carte> créerJeu32DansOrdre () {
        ArrayList<Carte> jeu = new ArrayList<Carte>();
        for (int indCouleur=0 ; indCouleur< COULEURS.length ; indCouleur++) {
            for (int valeur=7 ; valeur <= 14 ; valeur ++) {
                jeu.add(new Carte(valeur, COULEURS[indCouleur]));
            }
        }
        return jeu;
    }

    /*
     * Retourne un jeu battu de 32 cartes.
     */
    public static ArrayList<Carte> créerJeu32Battu () {
        ArrayList<Carte> jeu = créerJeu32DansOrdre();
        Collections.shuffle(jeu);  // la méthode static shuffle de la classe Collections réalise une permutation aléatoire.
        return jeu;
    }

    /*
     * Remplit aléatoirement paquet1 et paquet2 avec un nouveau jeu de 32 cartes
     * (les 32 cartes sont distribuées aléatoirement entre paquet1 et paquet2)
     * (16 cartes sont ajoutées dans chaque paquet).
     */
    public static void créerEtDistribuerJeu32(ArrayList<Carte> paquet1, ArrayList<Carte> paquet2) {
        ArrayList<Carte> jeuCompletBattu = créerJeu32Battu();
        for (int i=0 ; i<jeuCompletBattu.size()-1 ; i+=2) {
            paquet1.add(jeuCompletBattu.get(i));
            paquet2.add(jeuCompletBattu.get(i+1));
        }
    }

}