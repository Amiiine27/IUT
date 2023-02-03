import java.util.Scanner;

class AvantageCom {

    public static void main(String[] args) {
      Scanner saisie = new Scanner(System.in);
      double PrixMini, reduc, Prix, MontantASC, PrixAPayer;

      PrixMini = 100;
      System.out.println("Quel est le montant à régler ? ");
      Prix = (saisie.nextDouble());

      if (Prix>0 && Prix<=PrixMini) {
        PrixAPayer = Prix;
        System.out.println("Le montant final s'élève à "+ PrixAPayer +" €");
        saisie.close();
      }

      else{
        while (Prix<=0) {
        System.out.println("Montant invalide !  Inserez un prix valide !");
        Prix = (saisie.nextDouble());
      }

      MontantASC = Prix - PrixMini;
      System.out.println("La réduction sera appliquée à "+ MontantASC +" €"); 
      
      reduc = MontantASC*0.95;
      PrixAPayer = 100 + reduc;

      System.out.println("Le montant final s'élève à "+ PrixAPayer +" €");
        
    saisie.close();
      }
      
}
} 

// A Ameliorer !!