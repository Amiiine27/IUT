import java.util.Scanner;
public class DiversesMethodesSurDesTableaux {

    
    // Déclaration d'une variable de type tableau de int.
    public static void main(String[] args) {
        int[] notesEnProg;
        Scanner saisie = new Scanner(System.in);
        notesEnProg = new int[3];

        // remplissage du tableau
        for (int i = 0; i < notesEnProg.length; i++) {

            System.out.println("Note de l'étudiant n° " + (i + 1) + " : ");

            // ci-dessous on suppose qu’il existe un scanner nommé saisie

            notesEnProg[i] = saisie.nextInt();
            // notesEnProg[i] = Integer.parseInt(saisie.nextLine());

        }

        // affichage du contenu du tableau avec un boucle for

        for (int i = 0; i < notesEnProg.length; i++) {

            System.out.println("La note de l'étudiant " + (i + 1) + " est : " + notesEnProg[i]);

        }

        // version 2 : affichage du contenu du tableau avec un boucle foreach

        for (int note : notesEnProg) {

            System.out.println(note);
        }
    }

    public static void saisie() {
        int[] notesEnProg;
        Scanner saisie = new Scanner(System.in);
        notesEnProg = new int[3];

        // remplissage du tableau
        for (int i = 0; i < notesEnProg.length; i++) {

            System.out.println("Note de l'étudiant n° " + (i + 1) + " : ");

            // ci-dessous on suppose qu’il existe un scanner nommé saisie

            notesEnProg[i] = saisie.nextInt();
            // notesEnProg[i] = Integer.parseInt(saisie.nextLine());

        }
    }

    public static int nbOccurrences(int[] tab, int val) {
        int occ = 0;
        for (int i : tab) {
            if (i == val) {
                occ++;
            }
        }
        return occ;
    }

    public static int nbStrictementNégatifs(int[] tab) {
        int occ = 0;
        for (int i : tab) {
            if (i < 0) {
                occ++;
            }
        }
        return occ;
    }

    public static int sommeValeurs (int[] tab){
        int somme=0;
        for (int i : tab) {
            somme = somme + i;
            }
        return somme;
    }

    public static boolean estPrésent (int[] tab, int val){
        boolean rep=false;
        for (int i : tab) {
            if (i==val){
                rep=true;
            }
        }
        return rep;
    }

    public static boolean tousPositifs (int[] tab){
        boolean rep=true;
        for(int i: tab){
            if (i<0){
                rep=false;
            }
        }
        return rep;
    }

    public static boolean doubletousNegatifs (double[] tab){
        boolean rep=true;
        for(double i: tab){
            if (i>0){
                rep=false;
            }
        }
        return rep;
    }

    public static double moyenneNotes(int[] tab){
        int somme=0;
        double moy=0;
        for (int i : tab){
            somme = somme + i;
            }
        moy = somme/tab.length;
        return moy;
    }

        public static int indicePremOccurrence(int[] tab, int val){
        int rep=-1;
        for (int i : tab){
                if (tab[i]==val){
                    rep = i;
                    return rep;
                }
        }
        return rep;
        }

    public static int indiceDernOccurrence(int[] tab, int val){
        int rep=-1;
        for (int i : tab){
            if (tab[i]==val){
                rep = i;
            }
        }
        return rep;
    }

    public static double plusGrandPositif (double[] tab){
        double plusGrand=0, rep=0;
        if (tab.length==0){
            rep=0;
        }
        for (double i : tab){
            if (i>0 && i>=plusGrand){
                plusGrand=i;
                rep=plusGrand;
            }
            else if (doubletousNegatifs(tab)==true){
                rep=-1;
            }

        }
        return rep;

    }

}