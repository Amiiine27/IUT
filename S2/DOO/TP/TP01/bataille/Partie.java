package bataille;
import java.util.ArrayList;

/*
 * La classe Partie fait fonctionner le jeu de bataille (elle contient la boucle principale du jeu).
 * Une partie oppose deux joueurs qui vont exécuter des tours de jeu jusqu'à ce que l'un d'eux gagne.
 *
 * Une Partie concerne deux Joueur.
 *
 * Responsabilités détaillées de la classe Partie :
 * - créer une nouvelle partie opposant deux Joueur
 * - faire jouer la partie (jouer des tours de jeu jusquà ce qu'un joueur gagne).
 * - dire qui est le gagnant ou bien si la partie est terminée
 *
 */
public class Partie {

    private Joueur joueur1, joueur2;

    public Partie (String nomJ1, String nomJ2) {

        // créer deux paquets de cartes contenant une distribution d'un jeu de 32 cartes
        ArrayList<Carte> paquet1, paquet2;
        paquet1 = new ArrayList<Carte>();
        paquet2 = new ArrayList<Carte>();
        FabriqueDeJeuxDe32Cartes.créerEtDistribuerJeu32(paquet1, paquet2);

        // créer les joueurs
        this.joueur1 = new Joueur(nomJ1, paquet1);
        this.joueur2 = new Joueur(nomJ2, paquet2);
    }

    public void jouer () {
        System.out.println("Nous commençons une nouvelle et grandiose partie qui oppose :");
        System.out.println("Joueur 1 : " + this.joueur1.toString());
        System.out.println("Joueur 2 : " + this.joueur2.toString());
        System.out.println();

        int compteurDeTours = 0;

        // boucle principale du jeu
        while (this.joueur1.resteCarte() && this.joueur2.resteCarte()) {
            compteurDeTours++;
            System.out.println("tour n°" + compteurDeTours);
            this.faireUnTourDeJeu();
            System.out.println(this.joueur1.toString());
            System.out.println(this.joueur2.toString());
            System.out.println();
        }


        // affichage du résultat
        if (this.joueur1.resteCarte())
            System.out.println(this.joueur1.getNom() + " a gagné !");
        else
            System.out.println(this.joueur2.getNom() + " a gagné !");
    }


    // dans cette version très simplifiée on ne traite pas la bataille : en cas de bataille on tire au sort.
    // TODO : implanter la bataille...
    private void faireUnTourDeJeu() {
        Carte cartePoséeJoueur1, cartePoséeJoueur2;

        // chaque joueur pose une carte sur le tapis de jeu
        cartePoséeJoueur1 = this.joueur1.poserUneCarte();
        System.out.println(this.joueur1.getNom() + " pose le " + cartePoséeJoueur1.toString());
        cartePoséeJoueur2 = this.joueur2.poserUneCarte();
        System.out.println(this.joueur2.getNom() + " pose le " + cartePoséeJoueur2.toString());

        // qui gagne le pli ?
        Joueur gagnantPli;
        if (cartePoséeJoueur1.supérieureA(cartePoséeJoueur2))
            gagnantPli = this.joueur1;
        else if (cartePoséeJoueur2.supérieureA(cartePoséeJoueur1))
            gagnantPli = this.joueur2;
        else if (Math.random()<0.5) // dans cette version simplifiée, en cas de bataille on tire au sort
            gagnantPli = this.joueur1;
        else
            gagnantPli = this.joueur2;

        System.out.println(gagnantPli.getNom() + " gagne le pli");

        // le pli est battu puis ramassé par le gagnant
        if (Math.random()<0.5) {
            gagnantPli.ramasserUneCarte(cartePoséeJoueur1);
            gagnantPli.ramasserUneCarte(cartePoséeJoueur2);
        }
        else {
            gagnantPli.ramasserUneCarte(cartePoséeJoueur2);
            gagnantPli.ramasserUneCarte(cartePoséeJoueur1);
        }
    }

}
