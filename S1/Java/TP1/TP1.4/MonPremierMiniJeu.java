import java.util.Scanner;
public class MonPremierMiniJeu {

	public static void main (String[] args){
		
                
		
                Scanner scanner = new Scanner(System.in).useDelimiter("\n");
		
		String pseudoJoueur1, pseudoJoueur2;

		// saisie des pseudos des joueurs
		System.out.print("Joueur 1 entrez votre pseudo :");
		pseudoJoueur1 = scanner.nextLine();
		System.out.print("Joueur 2 entrez votre pseudo :");
		pseudoJoueur2 = scanner.nextLine();
		System.out.println("Le joueur 1 s'appelle : " + pseudoJoueur1);
		System.out.println("Le joueur 2 s'appelle : " + pseudoJoueur2);
		
		// qui gagne ?
		if (pseudoJoueur1.length() < pseudoJoueur2.length())
			System.out.println("C'est " + pseudoJoueur2 + " qui gagne !");
		else if (pseudoJoueur1.length() == pseudoJoueur2.length())
                        System.out.println("Egalité !");  
                else 
		       System.out.println("C'est " + pseudoJoueur1 + " qui gagne !");
                     
					
		;  
                        
		scanner.close();
	}	
	
}

