import java.util.Scanner;

public class Lanceur {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] tab = new char[8][8];

        String joueur1, joueur2;
        int ligne, colonne;

        boolean reponseFinal = true;
        boolean reponseFinalJ1;
        boolean reponseFinalJ2;

        System.out.println("Saisir le nom de joueur 1");
        joueur1 = scanner.nextLine();
        System.out.println("Saisir le nom de joueur 2");
        joueur2 = scanner.nextLine();

        Methodes.remplirTableau(tab);

        Methodes.mettreUnPionPourEssaie(tab,0,1,' ');
        Methodes.mettreUnPionPourEssaie(tab,2,3,Methodes.NOIR);
        Methodes.mettreUnPionPourEssaie(tab,7,4,' ');
        Methodes.mettreUnPionPourEssaie(tab,5,2,Methodes.BLANC);
        Methodes.affichePlateau(tab);

        while (reponseFinal) {
            System.out.println("Bonne chance " + joueur1 + " Vous avez les pions noirs");
            do {
                do {
                    System.out.print("choisisez la ligne du pion pour déplacer le pion noir : ");
                    ligne = scanner.nextInt();
                    System.out.print("choisisez la colonne du pion pour déplacer le pion noir : ");
                    colonne = scanner.nextInt();
                    if (colonne < 0 || colonne > 7 || ligne < 0 || ligne > 7 || tab[ligne][colonne] == Methodes.BLANC || tab[ligne][colonne] == Methodes.DAME_BLANC) {
                        System.out.println("la position des pions est entre 0 et 7 inclus ou  choisissez la poisition d'un pion noir");
                    }
                } while (colonne < 0 || colonne > 7 || ligne < 0 || ligne > 7 || tab[ligne][colonne] == Methodes.BLANC || tab[ligne][colonne] == Methodes.DAME_BLANC);
                reponseFinalJ1 = Methodes.deplacementPionNoir(tab, ligne, colonne);

                if (!reponseFinalJ1) {
                    System.out.println("choisisez un autre pion vous ne pouvez pas déplacer ce pion");
                }
            } while (!reponseFinalJ1);

            Methodes.affichePlateau(tab);

            if (Methodes.pionNoirGagne(tab) || Methodes.siLesPionsBlancheSontBlouqé(tab)) { // la méthode si le joueur1 a gangé dans le cas s'il n'y pas des pions blans ou ils sont tous blouqé
                System.out.println(joueur1 + " a gangné ");
                if (Methodes.siLesPionsBlancheSontBlouqé(tab)) {
                    System.out.println(joueur2 + " vous avez perdu car tous vos pions sont blouqés");
                }
                return;
            }
            System.out.println("Bonne chance " + joueur2 + " Vous avez les pions blancs");
            do {
                do {
                    System.out.print("choisissez la ligne du pion pour déplacer le pion blanc : ");
                    ligne = scanner.nextInt();
                    System.out.print("choisissez la colonne du pion pour déplacer le pion blanc : ");
                    colonne = scanner.nextInt();
                    if ((colonne < 0) || (colonne > 7) || (ligne < 0) || (ligne > 7) || (tab[ligne][colonne] == Methodes.NOIR) || (tab[ligne][colonne] == Methodes.DAME_NOIR)) {
                        System.out.println("la position des pions sont entre 0 et 7 inclus, ou choisissez la poisition d'un pion blanc");
                    }
                } while (colonne < 0 || colonne > 7 || ligne < 0 || ligne > 7 || tab[ligne][colonne] == Methodes.NOIR || tab[ligne][colonne] == Methodes.DAME_NOIR );
                reponseFinalJ2 = Methodes.deplacementPionBlanc(tab, ligne, colonne);
                if (!reponseFinalJ2) {
                    System.out.println("choisissez un autre pion vous ne pouvez pas déplacer ce pion");
                }
            } while (!reponseFinalJ2);
            Methodes.affichePlateau(tab);
            if (Methodes.pionBlancGagne(tab) || Methodes.siLesPionsNoirSontBloqué(tab)) { // la méthode si le joueur2 a gangé dans le cas s'il n'y plus les pions noirs ou ils sont tous blouqé
                System.out.println(joueur2 + " a gangné ");
                if (Methodes.siLesPionsNoirSontBloqué(tab)) {
                    System.out.println(joueur1 + " Vous avez perdu car tout vos pions sont blouqés");
                }
                return;
            }

            if (Methodes.tabComptePourNbFoisPionBlancJouéSansPrise[0] >= 20 || Methodes.tabComptPourNbFoisPionNoirJouéSansPrise[0] >= 20) {
                System.out.println("La partie se fini sur une égalité ");
                return;
            }
        }

    }
}