import java.util.Scanner;

public class Methodes {

    public static Scanner sc = new Scanner(System.in);
    final static char DAME_NOIR = 9651;
    final static char DAME_BLANC = 9650;
    final static char VIDE = 9636;
    final static char BLANC = 9679;
    final static char NOIR = 9675;

    static int[] tabComptPourNbFoisPionNoirJouĆ©SansPrise = new int[1];
    static int[] tabComptePourNbFoisPionBlancJouĆ©SansPrise = new int[1];

    static int[] tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse = new int[1];


    public static void affichePlateau(char[][] tab) {
        int nblignes = 0;
        int nbColonne = 0;
        for (int j = 0; j < tab.length; j++) {
            System.out.print("+-" + j + "-");
        }
        System.out.println();
        for (int i = 0; i < tab.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < tab[i].length; j++) {
                System.out.print(tab[i][j]);
                System.out.print(" | ");
                if (j == tab.length - 1) {
                    System.out.print(nblignes);
                    nblignes++;
                }

            }
            System.out.println();
            for (int j = 0; j < tab.length; j++) {
                if (i == tab.length - 1) {
                    System.out.print("+-" + nbColonne + "-");
                    nbColonne++;
                } else {
                    System.out.print("+--+");
                }
            }
            System.out.println();
        }
    }

    public static void remplirTableau(char[][] tab) {
        for (int ligne = 0; ligne < tab.length; ligne++) {
            for (int colonne = 0; colonne < tab[ligne].length; colonne++) {
                if (ligne >= 0 && ligne <= 2) {
                    if (ligne % 2 == 0) {
                        if (colonne % 2 == 0)
                            tab[ligne][colonne] = VIDE;
                        else
                            tab[ligne][colonne] = BLANC;
                    } else if ((ligne % 2 != 0)) {
                        if (colonne % 2 == 0)
                            tab[ligne][colonne] = BLANC;
                        else
                            tab[ligne][colonne] = VIDE;
                    }

                }
                if (ligne == 3 || ligne == 4) {
                    if (ligne % 2 == 0) {
                        if (colonne % 2 == 0)
                            tab[ligne][colonne] = VIDE;
                        else
                            tab[ligne][colonne] = ' ';
                    } else if ((ligne % 2 != 0)) {
                        if (colonne % 2 == 0)
                            tab[ligne][colonne] = ' ';
                        else
                            tab[ligne][colonne] = VIDE;
                    }

                }
                if (ligne >= 5 && ligne <= tab.length) {
                    if (ligne % 2 == 0) {
                        if (colonne % 2 == 0)
                            tab[ligne][colonne] = VIDE;
                        else
                            tab[ligne][colonne] = NOIR;
                    } else if ((ligne % 2 != 0)) {
                        if (colonne % 2 == 0)
                            tab[ligne][colonne] = NOIR;
                        else
                            tab[ligne][colonne] = VIDE;
                    }
                }
            }


        }
        System.out.println();
    }


    public static boolean verificationSiPion(char[][] tab, int ligne, int colonne) {
        return (tab[ligne][colonne] != ' ');
    }

    public static void enleverLesPionsJouĆ©s(char[][] tab, int ligne, int colonne) {
        tab[ligne][colonne] = ' ';
    }


    public static boolean verificationPionBlancCĆ“tĆ©GaucheNoir(char[][] tab, int ligne, int colonne) {
        //retourne true quand Ć  gauche du pions noirs  il y'a un pion blanc dans le cas ou le pion noir n'est pas la colonne zĆ©ro et pas dans la ligne ZĆ©ro
        if (ligne > 0 && colonne > 0) {
            // vĆ©rifier que tout les pions noirs ne pauvent pas de dĆ©placer Ć  gauche
            ligne = ligne - 1;
            colonne = colonne - 1;
            if (tab[ligne][colonne] == BLANC || tab[ligne][colonne] == DAME_BLANC) {
                return true;
            }
        }
        return false;
    }

    public static boolean verificationPionBlancCĆ“tĆ©DroitNoir(char[][] tab, int ligne, int colonne) {
        //retourne true quand Ć  droite du pions noirs s'il y'a un pion blanc dans le cas ou le pion noir n'est pas la colonne 7 et pas dans la ligne plus que zĆ©ro sinon Ć§a retourne false
        if (ligne > 0 && colonne < 7) {
            ligne = ligne - 1;
            colonne = colonne + 1;
            if (tab[ligne][colonne] == BLANC || tab[ligne][colonne] == DAME_BLANC) {
                return true;
            }
        }
        return false;
    }


    public static boolean verificationSiPionNoirBasGauche(char[][] tab, int ligne, int colonne) {
        // faire commentaire
        if (ligne < 7 && colonne > 0) {
            ligne = ligne + 1;
            colonne = colonne - 1;
            if (tab[ligne][colonne] == NOIR || tab[ligne][colonne] == DAME_NOIR) {
                return true;
            }
        }
        return false;
    }

    public static boolean verificationSiPionNoirBasDroite(char[][] tab, int ligne, int colonne) {
        // faire commentaire
        if (ligne < 7 && colonne < 7) {
            ligne = ligne + 1;
            colonne = colonne + 1;
            if (tab[ligne][colonne] == NOIR || tab[ligne][colonne] == DAME_NOIR) {
                return true;
            }
        }
        return false;
    }


    public static void devenirDameNoire(char tab[][], int ligne, int colonne) {
        if (ligne == 2 && (verificationPionBlancCĆ“tĆ©DroitNoir(tab, ligne, colonne) && verificationLesPionsHautDroiteDeuxiĆØmeLigne(tab, ligne, colonne))) {
            ligne = ligne - 2;
            colonne = colonne + 2;
            tab[ligne][colonne] = DAME_NOIR;
            enleverLesPionsJouĆ©s(tab, ligne + 1, colonne - 1); // retirer le pion enemie
            enleverLesPionsJouĆ©s(tab, ligne + 2, colonne - 2);//retirer le pion jouĆ©
        }
        if (ligne == 2 && (verificationPionBlancCĆ“tĆ©GaucheNoir(tab, ligne, colonne) && verificationLesPionsHautGaucheDeuxiĆØmeLigne(tab, ligne, colonne))) {
            ligne = ligne - 2;
            colonne = colonne - 2;
            tab[ligne][colonne] = DAME_NOIR;
            enleverLesPionsJouĆ©s(tab, ligne + 1, colonne + 1); // retirer le pion enemie
            enleverLesPionsJouĆ©s(tab, ligne + 2, colonne + 2);//retirer le pion jouĆ©
        }

    }

    public static void devenirDameBlanche(char[][] tab, int ligne, int colonne) {
        if (ligne == 5 && verificationSiPionNoirBasGauche(tab, ligne, colonne) && verificationLesPionsBasGaucheDeuxiĆØmeLigne(tab, ligne, colonne)) {
            ligne = ligne + 2;
            colonne = colonne - 2;
            tab[ligne][colonne] = DAME_BLANC;
            enleverLesPionsJouĆ©s(tab, ligne - 1, colonne + 1); // retirer le pion enemie
            enleverLesPionsJouĆ©s(tab, ligne - 2, colonne + 2);//retirer le pion jouĆ©
        }
        if (ligne == 5 && verificationSiPionNoirBasDroite(tab, ligne, colonne) && verificationLesPionsBasDroiteDeuxiĆØmeLigne(tab, ligne, colonne)) {
            ligne = ligne + 2;
            colonne = colonne + 2;
            tab[ligne][colonne] = DAME_BLANC;
            enleverLesPionsJouĆ©s(tab, ligne - 1, colonne - 1); // retirer le pion enemie
            enleverLesPionsJouĆ©s(tab, ligne - 2, colonne - 2);//retirer le pion jouĆ©
        }

    }

    public static boolean deplacementDame(char tab[][], int ligne, int colonne) {
        int choix;

        if (tab[ligne][colonne] == DAME_NOIR) {
            boolean basGaucheDN = verificationLesPionsBasGauche(tab, ligne, colonne)
                    || (!verificationSiPionNoirBasGauche(tab, ligne, colonne)
                    && verificationLesPionsBasGaucheDeuxiĆØmeLigne(tab, ligne, colonne));
            boolean basDroiteDN = verificationLesPionsBasDroite(tab, ligne, colonne)
                    || (!verificationSiPionNoirBasDroite(tab, ligne, colonne)
                    && verificationLesPionsBasDroiteDeuxiĆØmeLigne(tab, ligne, colonne));
            boolean hautGaucheDN = verificationLesPionsHautGauche(tab, ligne, colonne)
                    || (verificationPionBlancCĆ“tĆ©GaucheNoir(tab, ligne, colonne)
                    && verificationLesPionsHautGaucheDeuxiĆØmeLigne(tab, ligne, colonne));
            boolean hautDroiteDN = verificationLesPionsHautDroite(tab, ligne, colonne)
                    || (verificationPionBlancCĆ“tĆ©DroitNoir(tab, ligne, colonne)
                    && verificationLesPionsHautDroiteDeuxiĆØmeLigne(tab, ligne, colonne));


            if (basGaucheDN || basDroiteDN || hautDroiteDN || hautGaucheDN) {
                if (basGaucheDN) {
                    System.out.println("1: Pour dĆ©placer en bas Ć  gauche");
                }
                if (basDroiteDN) {
                    System.out.println("2: Pour dĆ©placer en bas Ć  droite");
                }
                if (hautGaucheDN) {
                    System.out.println("3: Pour dĆ©placer en haut Ć  gauche");
                }
                if (hautDroiteDN) {
                    System.out.println("4: Pour dĆ©placer en haut Ć  droite");
                }
                choix = sc.nextInt();

            } else {
                // System.out.println("tu ne peux pas dĆ©placeer cette dame choisi un autre pion"); // dans le si tu ne peux pas dĆ©placer le dame
                return false;
            }


        } else {

            boolean basGaucheDB = (verificationLesPionsBasGauche(tab, ligne, colonne)
                    || (verificationSiPionNoirBasGauche(tab, ligne, colonne)
                    && verificationLesPionsBasGaucheDeuxiĆØmeLigne(tab, ligne, colonne)));
            boolean basDroiteDB = (verificationLesPionsBasDroite(tab, ligne, colonne)
                    || (verificationSiPionNoirBasDroite(tab, ligne, colonne)
                    && verificationLesPionsBasDroiteDeuxiĆØmeLigne(tab, ligne, colonne)));
            boolean hautGaucheDB = (verificationLesPionsHautGauche(tab, ligne, colonne)
                    || (!verificationPionBlancCĆ“tĆ©GaucheNoir(tab, ligne, colonne)
                    && verificationLesPionsHautGaucheDeuxiĆØmeLigne(tab, ligne, colonne)));
            boolean hautDroiteDB = (verificationLesPionsHautDroite(tab, ligne, colonne)
                    || (!verificationPionBlancCĆ“tĆ©DroitNoir(tab, ligne, colonne)
                    && verificationLesPionsHautDroiteDeuxiĆØmeLigne(tab, ligne, colonne)));

            if (basGaucheDB || basDroiteDB || hautDroiteDB || hautGaucheDB) {
                if (basGaucheDB) {
                    System.out.println("1: Pour dĆ©placer en bas Ć  gauche");
                }
                if (basDroiteDB) {
                    System.out.println("2: Pour dĆ©placer en bas Ć  droite");
                }
                if (hautGaucheDB) {
                    System.out.println("3: Pour dĆ©placer en haut Ć  gauche");
                }
                if (hautDroiteDB) {
                    System.out.println("4: Pour dĆ©placer en haut Ć  droite");
                }
                choix = sc.nextInt();
            } else {

                return false;
            }

        }
        char choixDame = tab[ligne][colonne];
        switch (choix) {
            case 1: {
                if (!verificationLesPionsBasGauche(tab, ligne, colonne)) {
                    if (verificationLesPionsBasGaucheDeuxiĆØmeLigne(tab, ligne, colonne)) {
                        ligne = ligne + 2;
                        colonne = colonne - 2;
                        tab[ligne][colonne] = choixDame;
                        enleverLesPionsJouĆ©s(tab, ligne - 1, colonne + 1); // retirer le pion adverse
                        enleverLesPionsJouĆ©s(tab, ligne - 2, colonne + 2); // retirer le pion jouĆ©
                        if (choixDame == DAME_NOIR) {
                            nbFoisPionJouĆ©SansPrisePionAdverse(tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse, -1);
                            System.out.println("si la dame noire a pris le pion adverse " + tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse[0]);
                        }
                        if (choixDame == DAME_BLANC) {
                            nbFoisPionJouĆ©SansPrisePionAdverse(tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse, -1);
                            System.out.println("si dame blanc a pris le pion advarsair " + tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse[0]);
                        }

                    }
                } else {
                    if (verificationLesPionsBasGauche(tab, ligne, colonne)){
                        tab[ligne + 1][colonne - 1] = choixDame;
                        enleverLesPionsJouĆ©s(tab, ligne, colonne);
                        if (choixDame == DAME_NOIR) {
                            nbFoisPionJouĆ©SansPrisePionAdverse(tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse, tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse[0]);
                            System.out.println("si dameNoire ne pas prise le pion advarsair " + tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse[0]);
                        }
                        if (choixDame == DAME_BLANC) {
                            nbFoisPionJouĆ©SansPrisePionAdverse(tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse, tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse[0]);
                            System.out.println("si dame blanc ne pas prise le pion advarsair " + tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse[0]);
                        }
                    }
                }
                break;
            }
            case 2: {
                if (!verificationLesPionsBasDroite(tab, ligne, colonne)) {
                    if (verificationLesPionsBasDroiteDeuxiĆØmeLigne(tab, ligne, colonne)) {
                        ligne = ligne + 2;
                        colonne = colonne + 2;
                        tab[ligne][colonne] = choixDame;
                        enleverLesPionsJouĆ©s(tab, ligne - 1, colonne - 1); // retirer le pion advarsaire
                        enleverLesPionsJouĆ©s(tab, ligne - 2, colonne - 2); // retirer le pion jouĆ©
                        if (choixDame == DAME_NOIR) {
                            nbFoisPionJouĆ©SansPrisePionAdverse(tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse, -1);              // si la dame noire prendre un pion advarsair le compteur vas mĆ©tre Ć  zĆ©ro
                            System.out.println("si dameNoire a pris le pion advarsair " + tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse[0]);
                        }
                        if (choixDame == DAME_BLANC) {
                            nbFoisPionJouĆ©SansPrisePionAdverse(tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse, -1);            // si la dame blanc prendre un pion advarsair le compteur vas mĆ©tre Ć  zĆ©ro
                            System.out.println("si dame blanc a pris le pion advarsair " + tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse[0]);
                        }
                    }
                } else {
                    if(verificationLesPionsBasDroite(tab, ligne, colonne)){
                        tab[ligne + 1][colonne + 1] = choixDame;
                        enleverLesPionsJouĆ©s(tab, ligne, colonne); // retirer le pion jouĆ©
                        if (choixDame == DAME_NOIR) {
                            nbFoisPionJouĆ©SansPrisePionAdverse(tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse, tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse[0]); // si la dame noire ne pas pris le pion advarsair il augumente Ć  chaque fois
                            System.out.println("si dameNoire ne pas prise le pion advarsair " + tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse[0]);
                        }
                        if (choixDame == DAME_BLANC) {
                            nbFoisPionJouĆ©SansPrisePionAdverse(tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse, tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse[0]); // si la dame blanche ne pas pris le pion advarsair il augumente Ć  chaque fois
                            System.out.println("si dame blanc ne pas prise le pion advarsair " + tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse[0]);
                        }
                    }
                }
                break;
            }
            case 3: {
                if (!verificationLesPionsHautGauche(tab, ligne, colonne)) {
                    if(verificationLesPionsHautGaucheDeuxiĆØmeLigne(tab,ligne,colonne)){
                        ligne = ligne - 2;
                        colonne = colonne - 2;
                        tab[ligne][colonne] = choixDame;
                        enleverLesPionsJouĆ©s(tab, ligne + 1, colonne + 1); // retirer le pion advarsaire
                        enleverLesPionsJouĆ©s(tab, ligne + 2, colonne + 2); // retirer le pion jouĆ©
                        if (choixDame == DAME_NOIR) {
                            nbFoisPionJouĆ©SansPrisePionAdverse(tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse, -1);
                            System.out.println("si dameNoire a pris le pion advarsair " + tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse[0]);
                        }
                        if (choixDame == DAME_BLANC) {
                            nbFoisPionJouĆ©SansPrisePionAdverse(tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse, -1);
                            System.out.println("si dame blanc a pris le pion advarsair " + tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse[0]);
                        }
                    }
                } else {
                    if (verificationLesPionsHautGauche(tab, ligne, colonne)){
                        tab[ligne - 1][colonne - 1] = choixDame;
                        enleverLesPionsJouĆ©s(tab, ligne, colonne); // retirer le pion jouĆ©
                        if (choixDame == DAME_NOIR) {
                            nbFoisPionJouĆ©SansPrisePionAdverse(tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse, tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse[0]);
                            System.out.println("si dameNoire ne pas prise  le pion advarsair " + tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse[0]);
                        }
                        if (choixDame == DAME_BLANC) {
                            nbFoisPionJouĆ©SansPrisePionAdverse(tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse, tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse[0]);
                            System.out.println("si dame blanc ne pas prise le pion advarsair " + tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse[0]);
                        }
                    }
                }
                break;
            }
            case 4: {
                if (!verificationLesPionsHautDroite(tab, ligne, colonne)) {
                    if(verificationLesPionsHautDroiteDeuxiĆØmeLigne(tab,ligne,colonne)){
                        ligne = ligne - 2;
                        colonne = colonne + 2;
                        tab[ligne][colonne] = choixDame;
                        enleverLesPionsJouĆ©s(tab, ligne + 1, colonne - 1);// retirer le pion advarsaire
                        enleverLesPionsJouĆ©s(tab, ligne + 2, colonne - 2);
                        if (choixDame == DAME_NOIR) {
                            nbFoisPionJouĆ©SansPrisePionAdverse(tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse, -1);
                            System.out.println("si dameNoire a pris le pion advarsair " + tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse[0]);
                        }
                        if (choixDame == DAME_BLANC) {
                            nbFoisPionJouĆ©SansPrisePionAdverse(tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse, -1);
                            System.out.println("si dame blanc a pris le pion advarsair " + tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse[0]);
                        }
                    }
                } else {
                    if (verificationLesPionsHautDroite(tab, ligne, colonne)) {
                        tab[ligne - 1][colonne + 1] = choixDame;
                        enleverLesPionsJouĆ©s(tab, ligne, colonne); // retirer le pion jouĆ©
                        if (choixDame == DAME_NOIR) {
                            nbFoisPionJouĆ©SansPrisePionAdverse(tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse, tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse[0]);
                            System.out.println("si dameNoire ne pas prise le pion advarsair " + tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse[0]);
                        }
                        if (choixDame == DAME_BLANC) {
                            nbFoisPionJouĆ©SansPrisePionAdverse(tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse, tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse[0]);
                            System.out.println("si dame blanc ne pas  prise le pion adverse " + tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse[0]);
                        }
                    }
                }
                break;
            }
        }
        return true;
    }


    public static boolean deplacementPionNoir(char[][] tab, int ligne, int colonne) {
        boolean laPaceDuPionChoisi;
        int nbFoisPionJouĆ© = 0;
        if (tab[ligne][colonne] == DAME_NOIR) {
            if (deplacementDame(tab, ligne, colonne)) {
                laPaceDuPionChoisi = true;
            } else {
                laPaceDuPionChoisi = false;
            }
        } else {
            int laPlaceChoisi;
            boolean cĆ“tĆ©HautGauche = (verificationLesPionsHautGauche(tab, ligne, colonne) // si en haut gauche prĆ©mier case est vide
                    || (verificationPionBlancCĆ“tĆ©GaucheNoir(tab, ligne, colonne)   //si c'est un pion blanc ou dame blanc
                    && verificationLesPionsHautGaucheDeuxiĆØmeLigne(tab, ligne, colonne))); // en deuxĆØ lignes le case diagonale est vide

            boolean cĆ“tĆ©HautDroite = (verificationLesPionsHautDroite(tab, ligne, colonne) // si en haut droite prĆ©mier case est vide
                    || (verificationPionBlancCĆ“tĆ©DroitNoir(tab, ligne, colonne)    //si c'est un pion blanc ou dame blanc
                    && verificationLesPionsHautDroiteDeuxiĆØmeLigne(tab, ligne, colonne))); // en deuxiĆØme lignes le case diagonale vers droite est vide
            if (verificationSiPion(tab, ligne, colonne) && (cĆ“tĆ©HautGauche || cĆ“tĆ©HautDroite)) {  // si la pion choisi est vrai et une place en lignes haut est vides
                laPaceDuPionChoisi = true;
                if (cĆ“tĆ©HautGauche && cĆ“tĆ©HautDroite) {

                    do {
                        boolean error = false;

                        System.out.println("saisir 1 pour deplacer le pion vers la gauche et 2 pour vers le droit");
                        laPlaceChoisi = sc.nextInt();

                    } while (laPlaceChoisi < 1 || laPlaceChoisi > 2);

                } else {
                    if (cĆ“tĆ©HautDroite) {
                        do {
                            System.out.println("saisir  2 pour deplacer vers le  droite ");
                            laPlaceChoisi = sc.nextInt();
                        } while (laPlaceChoisi != 2);

                    } else {
                        do {
                            System.out.println("saisir 1 pour deplacer Ć  la gauche");
                            laPlaceChoisi = sc.nextInt();
                        } while (laPlaceChoisi != 1);

                    }
                }

                switch (laPlaceChoisi) {
                    case 1:
                        if (verificationPionBlancCĆ“tĆ©GaucheNoir(tab, ligne, colonne) && verificationLesPionsHautGaucheDeuxiĆØmeLigne(tab, ligne, colonne)) {
                            // dans le cas si la premiere case haut gauche diagonale est comple la deuxiĆØmes case haut gauche diagonale  est vide
                            if (ligne == 2) {
                                devenirDameNoire(tab, ligne, colonne);
                                nbFoisPionJouĆ©SansPrisePionAdverse(tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse, -1);
                                System.out.println("Dans le cas si le pion noire prendre pion advarsaire " + tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse[0]);
                            } else {
                                ligne = ligne - 2;
                                colonne = colonne - 2;
                                tab[ligne][colonne] = NOIR;
                                enleverLesPionsJouĆ©s(tab, ligne + 1, colonne + 1);//retirer le pion jouĆ©
                                enleverLesPionsJouĆ©s(tab, ligne + 2, colonne + 2);
                                nbFoisPionJouĆ©SansPrisePionAdverse(tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse, -1);
                                System.out.println("Dans le cas si le pion noire prendre pion advarsaire " + tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse[0]);
                            }


                        } else {
                            // dans le cas si la premiere case haut gauche diagonale est vide
                            tab[ligne - 1][colonne - 1] = NOIR;
                            enleverLesPionsJouĆ©s(tab, ligne, colonne);
                            nbFoisPionJouĆ©SansPrisePionAdverse(tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse, tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse[0]);
                            System.out.println("Dans le cas si le pion noire ne prendre pas  pion advarsaire " + tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse[0]);
                        }
                        break;
                    case 2:
                        if (verificationPionBlancCĆ“tĆ©DroitNoir(tab, ligne, colonne) && verificationLesPionsHautDroiteDeuxiĆØmeLigne(tab, ligne, colonne)) {
                            // dans le cas si la premiere case haut droite diagonale est comple la deuxiĆØmes case haut droite diagonale  est vide
                            if (ligne == 2) {
                                devenirDameNoire(tab, ligne, colonne);
                                nbFoisPionJouĆ©SansPrisePionAdverse(tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse, -1);
                                System.out.println("Dans le cas si le pion noire prendre pion advarsaire " + tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse[0]);
                            } else {
                                ligne = ligne - 2;
                                colonne = colonne + 2;
                                tab[ligne][colonne] = NOIR;
                                enleverLesPionsJouĆ©s(tab, ligne + 1, colonne - 1); // retirer le pion enimies
                                enleverLesPionsJouĆ©s(tab, ligne + 2, colonne - 2);//retirer le pion jouĆ©
                                nbFoisPionJouĆ©SansPrisePionAdverse(tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse, -1); // dans le cas si un pion advarsair est pris  le valeur devient Ć  zĆ©ro
                                System.out.println("Dans le cas si le pion noire prendre pion advarsaire " + tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse[0]);
                            }
                        } else {
                            // dans le cas si la premiere case haut droite  diagonale est vide
                            tab[ligne - 1][colonne + 1] = NOIR;
                            enleverLesPionsJouĆ©s(tab, ligne, colonne);
                            nbFoisPionJouĆ©SansPrisePionAdverse(tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse, tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse[0]);
                            System.out.println("Dans le cas si le pion noire ne prendre pas  pion advarsaire " + tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse[0]);
                        }
                        break;
                }

            } else { // si les deux place en linge ne sont pas vides
                laPaceDuPionChoisi = false;
            }
        }
        return laPaceDuPionChoisi;
    }


    public static int[] nbFoisPionJouĆ©SansPrisePionAdverse(int[] tab, int nbFoisPion) {
        nbFoisPion++;
        tab[0] = nbFoisPion;
        return tab;
    }

    // verification de pions noire s'ils sont bloquĆ©s retouner vrai
    public static boolean siLesPionsNoirSontBloquĆ©(char[][] tab) {
        for (int ligne = 0; ligne < tab.length; ligne++) {
            for (int colonne = 0; colonne < tab[ligne].length; colonne++) {
                boolean cĆ“tĆ©HautGauche = (verificationLesPionsHautGauche(tab, ligne, colonne)        // si en haut gauche prĆ©mier case est vide
                        || (verificationPionBlancCĆ“tĆ©GaucheNoir(tab, ligne, colonne)              //si c'est un pion blanc ou dame blanc
                        && verificationLesPionsHautGaucheDeuxiĆØmeLigne(tab, ligne, colonne)));      // en deuxĆØ lignes le case diagonale est vide

                boolean cĆ“tĆ©HautDroite = (verificationLesPionsHautDroite(tab, ligne, colonne)       // si en haut droite prĆ©mier case est vide
                        || (verificationPionBlancCĆ“tĆ©DroitNoir(tab, ligne, colonne)               //si c'est un pion blanc ou dame blanc
                        && verificationLesPionsHautDroiteDeuxiĆØmeLigne(tab, ligne, colonne)));      // en deuxiĆØme lignes le case diagonale vers droite est vide

                boolean cĆ“teBasGauche = (verificationLesPionsBasGauche(tab, ligne, colonne)         // si en bas gauche case est vide
                        || (!verificationSiPionNoirBasGauche(tab, ligne, colonne)                   // ou si le premier case est complet
                        && verificationLesPionsBasGaucheDeuxiĆØmeLigne(tab, ligne, colonne)));       // et en deuĆØxime ligne le case digonale est vide

                boolean cĆ“teBahDroite = (verificationLesPionsBasDroite(tab, ligne, colonne)
                        || (!verificationSiPionNoirBasDroite(tab, ligne, colonne)
                        && verificationLesPionsBasDroiteDeuxiĆØmeLigne(tab, ligne, colonne)));


                if (tab[ligne][colonne] == NOIR && (cĆ“tĆ©HautGauche || cĆ“tĆ©HautDroite)) {
                    return false;

                }
                if (tab[ligne][colonne] == DAME_NOIR && (cĆ“tĆ©HautGauche || cĆ“tĆ©HautDroite || cĆ“teBasGauche || cĆ“teBahDroite)) {
                    return false;
                }


            }

        }
        return true;
    }


    public static boolean deplacementPionBlanc(char[][] tab, int ligne, int colonne) {
        boolean laPaceDePionChoisi;
        if (tab[ligne][colonne] == DAME_BLANC) {                                                    // dans le cas si le pion choisi est une dame blanche
            if (deplacementDame(tab, ligne, colonne)) {
                laPaceDePionChoisi = true;
            } else {
                laPaceDePionChoisi = false;
            }

        } else {
            int laPlaceChoisi;
            boolean cĆ“tĆ©BasGauche = (verificationLesPionsBasGauche(tab, ligne, colonne)             // si le premer case est vide
                    || (verificationSiPionNoirBasGauche(tab, ligne, colonne)                        // le premer case noire et
                    && verificationLesPionsBasGaucheDeuxiĆØmeLigne(tab, ligne, colonne)));           // deuxiĆØseme case vide

            boolean cĆ“tĆ©BasDroite = (verificationLesPionsBasDroite(tab, ligne, colonne)             // si le premer case est vide
                    || (verificationSiPionNoirBasDroite(tab, ligne, colonne)                        // le premer case noire et
                    && verificationLesPionsBasDroiteDeuxiĆØmeLigne(tab, ligne, colonne)));           // deuxiĆØseme case vide

            if (verificationSiPion(tab, ligne, colonne) && (cĆ“tĆ©BasGauche || cĆ“tĆ©BasDroite)) {      // si la pion choisi est vrai et une place en lignes haut est vides
                laPaceDePionChoisi = true;
                if (cĆ“tĆ©BasGauche && cĆ“tĆ©BasDroite) {
                    do {
                        System.out.println("saisir 1 pour deplacer le pion vers la gauche et 2 pour vers le droit");
                        laPlaceChoisi = sc.nextInt();
                    } while (laPlaceChoisi < 1 || laPlaceChoisi > 2);
                } else {
                    if (cĆ“tĆ©BasDroite) {
                        do {
                            System.out.println("saisir  2 pour deplacer vers le  droite ");
                            laPlaceChoisi = sc.nextInt();
                        } while (laPlaceChoisi != 2);

                    } else {
                        do {
                            System.out.println("saisir 1 pour deplacer Ć  la gauche");
                            laPlaceChoisi = sc.nextInt();
                        } while (laPlaceChoisi != 1);
                    }
                }
                switch (laPlaceChoisi) {
                    case 1:
                        if (verificationSiPionNoirBasGauche(tab, ligne, colonne)
                                && verificationLesPionsBasGaucheDeuxiĆØmeLigne(tab, ligne, colonne)) {
                            // dans le cas si la premiere case bas gauche diagonale est comple la deuxiĆØmes case bas gauche diagonale  est vide
                            if (ligne == 5) {
                                devenirDameBlanche(tab, ligne, colonne);
                                nbFoisPionJouĆ©SansPrisePionAdverse(tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse, -1);
                                System.out.println("dans le cas si le pion blanc prendre le pion advarsair " + tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse[0]);

                            } else {
                                ligne = ligne + 2;
                                colonne = colonne - 2;
                                tab[ligne][colonne] = BLANC;
                                enleverLesPionsJouĆ©s(tab, ligne - 1, colonne + 1);//retirer le pion jouĆ©
                                enleverLesPionsJouĆ©s(tab, ligne - 2, colonne + 2);
                                nbFoisPionJouĆ©SansPrisePionAdverse(tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse, -1);
                                System.out.println("dans le cas si le pion blanc prendre le pion advarsair " + tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse[0]);
                            }
                        } else {
                            // dans le cas si la premiere case haut gauche diagonale est vide
                            tab[ligne + 1][colonne - 1] = BLANC;
                            enleverLesPionsJouĆ©s(tab, ligne, colonne);
                            nbFoisPionJouĆ©SansPrisePionAdverse(tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse, tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse[0]);
                            System.out.println("dans le cas si le pion blanc ne prendre pas le pion advarsair" + tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse[0]);
                        }
                        break;
                    case 2:
                        if (verificationSiPionNoirBasDroite(tab, ligne, colonne)
                                && verificationLesPionsBasDroiteDeuxiĆØmeLigne(tab, ligne, colonne)) {
                            // dans le cas si la premiere case bas droite diagonale est complet  la deuxiĆØmes case haut droite diagonale  est vide
                            if (ligne == 5) {
                                devenirDameBlanche(tab, ligne, colonne);
                                nbFoisPionJouĆ©SansPrisePionAdverse(tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse, -1);
                                System.out.println("dans le cas si le pion blanc prendre le pion advarsair " + tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse[0]);
                            } else {
                                ligne = ligne + 2;
                                colonne = colonne + 2;
                                tab[ligne][colonne] = BLANC;
                                enleverLesPionsJouĆ©s(tab, ligne - 1, colonne - 1); // retirer le pion enimies
                                enleverLesPionsJouĆ©s(tab, ligne - 2, colonne - 2);//retirer le pion jouĆ©
                                nbFoisPionJouĆ©SansPrisePionAdverse(tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse, -1);
                                System.out.println("dans le cas si le pion blanc prendre le pion advarsair " + tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse[0]);
                            }
                        } else {
                            // dans le cas si la premiere case bas droite  diagonale est vide
                            tab[ligne + 1][colonne + 1] = BLANC;
                            enleverLesPionsJouĆ©s(tab, ligne, colonne);
                            nbFoisPionJouĆ©SansPrisePionAdverse(tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse, tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse[0]);
                            System.out.println("dans le cas si le pion blanc  ne prendre pas  le pion advarsair " + tabCompteNbrFoisPionJouĆ©SansPrisePionAdverse[0]);
                        }
                        break;
                }

            } else { // si les deux place en linge ne sont pas vides
                laPaceDePionChoisi = false;
            }
        }
        return laPaceDePionChoisi;
    }

    // cet mĆ©thode c'est pour compter les numbres des fois pion blanc jouĆ©  sans prise le pion advarair
    public static int[] nbFoisPionBlancJouĆ©SansPrisePionAdverse(int[] tab, int nbFoisPion) {
        nbFoisPion++;
        tab[0] = nbFoisPion;
        return tab;
    }

    // verification de pions blanc s'ils sont bloquĆ© retouner vraie
    public static boolean siLesPionsBlancheSontBlouqĆ©(char[][] tab) {
        for (int ligne = 0; ligne < tab.length; ligne++) {
            for (int colonne = 0; colonne < tab[ligne].length; colonne++) {
                boolean cĆ“tĆ©BasGauche = (verificationLesPionsBasGauche(tab, ligne, colonne)             // si le premer case est vide
                        || (verificationSiPionNoirBasGauche(tab, ligne, colonne)                        // le premer case noire et
                        && verificationLesPionsBasGaucheDeuxiĆØmeLigne(tab, ligne, colonne)));           // deuxiĆØseme case vide

                boolean cĆ“tĆ©BasDroite = (verificationLesPionsBasDroite(tab, ligne, colonne)             // si le premer case est vide
                        || (verificationSiPionNoirBasDroite(tab, ligne, colonne)                        // le premer case noire et
                        && verificationLesPionsBasDroiteDeuxiĆØmeLigne(tab, ligne, colonne)));           // deuxiĆØseme case vide

                boolean cĆ“tĆ©HautGauch = (verificationLesPionsHautGauche(tab, ligne, colonne)
                        || (!verificationPionBlancCĆ“tĆ©GaucheNoir(tab, ligne, colonne)
                        && verificationLesPionsHautGaucheDeuxiĆØmeLigne(tab, ligne, colonne)));

                boolean cĆ“tĆ©HautDroit = (verificationLesPionsHautDroite(tab, ligne, colonne)
                        || (!verificationPionBlancCĆ“tĆ©DroitNoir(tab, ligne, colonne)
                        && verificationLesPionsHautDroiteDeuxiĆØmeLigne(tab, ligne, colonne)));
                if (tab[ligne][colonne] == BLANC && (cĆ“tĆ©BasGauche || cĆ“tĆ©BasDroite)) {
                    return false;
                }
                if (tab[ligne][colonne] == DAME_BLANC && (cĆ“tĆ©BasGauche || cĆ“tĆ©BasDroite || cĆ“tĆ©HautDroit || cĆ“tĆ©HautGauch)) {
                    return false;
                }
            }
        }
        return true;
    }


    // vĆ©rification le case vers haut gauche s'il est vide
    public static boolean verificationLesPionsHautGauche(char[][] tab, int ligne, int colonne) {
        if (ligne > 0 && colonne > 0) {
            ligne = ligne - 1;
            colonne = colonne - 1;
            if (tab[ligne][colonne] == ' ') {
                return true;
            }
        }
        return false;
    }

    // vĆ©rification la case de deuxiĆØme ligne s'il est vide
    public static boolean verificationLesPionsHautGaucheDeuxiĆØmeLigne(char[][] tab, int ligne, int colonne) {
        if (ligne > 1 && colonne > 1) {
            ligne = ligne - 2;
            colonne = colonne - 2;
            if (tab[ligne][colonne] == ' ') {
                return true;
            }
        }
        return false;
    }


    // verification si le case  haut droit est vides
    public static boolean verificationLesPionsHautDroite(char[][] tab, int ligne, int colonne) {
        if (ligne > 0 && colonne < 7) {
            ligne = ligne - 1;
            colonne = colonne + 1;
            if (tab[ligne][colonne] == ' ') {
                return true;
            }
        }
        return false;
    }

    // verification si le case de deuxiĆØme ligne haut droit est vides
    public static boolean verificationLesPionsHautDroiteDeuxiĆØmeLigne(char[][] tab, int ligne, int colonne) {
        if (ligne > 1 && colonne < 6) {
            ligne = ligne - 2;
            colonne = colonne + 2;
            if (tab[ligne][colonne] == ' ') {
                return true;
            }
        }
        return false;
    }


    // verification si le case en bas gauche est vide
    public static boolean verificationLesPionsBasGauche(char[][] tab, int ligne, int colonne) {
        if (ligne < 7 && colonne > 0) {
            ligne = ligne + 1;
            colonne = colonne - 1;
            if (tab[ligne][colonne] == ' ') {
                return true;
            }
        }
        return false;
    }


    // verification si le case en deuxiĆØme ligne bas gauche est vide
    public static boolean verificationLesPionsBasGaucheDeuxiĆØmeLigne(char[][] tab, int ligne, int colonne) {
        if (ligne < 6 && colonne > 1) {
            ligne = ligne + 2;
            colonne = colonne - 2;
            if (tab[ligne][colonne] == ' ') {
                return true;
            }
        }
        return false;
    }


    //verification si le case en bas droit est vide
    public static boolean verificationLesPionsBasDroite(char[][] tab, int ligne, int colonne) {
        if (ligne < 7 && colonne < 7) {
            ligne = ligne + 1;
            colonne = colonne + 1;
            if (tab[ligne][colonne] == ' ') {
                return true;
            }
        }
        return false;
    }


    //verification si le case en deuxiĆØme lignes en bas droit est vide
    public static boolean verificationLesPionsBasDroiteDeuxiĆØmeLigne(char[][] tab, int ligne, int colonne) {
        if (ligne < 6 && colonne < 6) {
            ligne = ligne + 2;
            colonne = colonne + 2;
            if (tab[ligne][colonne] == ' ') {
                return true;
            }

        }
        return false;
    }


    public static boolean pionBlancGagne(char[][] tab) { // dans le cas s'il y a aucun pion et dame noir
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                if (i < 7) { // la premiĆØre ligne ne doit pas parcourire pour les pions noirs, si les pions noirs sont dans la premiĆØre lignes  ils ne pouvent ĆŖtre jouĆ©
                    if (tab[i + 1][j] == NOIR) {
                        return false;
                    }
                }
                if (tab[i][j] == DAME_NOIR) { // parcourire toute la tableau pour vĆ©rification de dame noire
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean pionNoirGagne(char[][] tab) { // dans le cas s'il y a aucun pion et dame blanc
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                if (i < 7) { // parcourire tous le tableau sauf derniĆØre ligne pour les pion blanche
                    if (tab[i][j] == BLANC) {
                        return false;
                    }
                }
                if (tab[i][j] == DAME_BLANC) {
                    return false;
                }
            }
        }
        return true;
    }


    public static char[][] mettreUnPionPourEssaie(char[][] tab, int ligne, int colonne, char pion) { //pour mettre les pion dans le tableau pour verifier les sous programme
        tab[ligne][colonne] = pion;
        return tab;
    }


}