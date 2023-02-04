public class Attaque {
    private int degats;
    private String nom, description;

    public Attaque(String n, String desc, int deg){
        nom = n;
        description = desc;
        degats = deg;
    }

    Attaque foudre = new Attaque("Foudre", "Envoie une décharge éléctrique à l'adversaire", 10),
            flamme = new Attaque("Flamme", "Lance une flamme sur l'adversaire", 10),
            jet_eau = new Attaque("Jet d'eau", "Envoie un jet d'eau sur l'adversaire", 10);
    }

    // A FAIRE : UNE ARRAY LIST AVEC UN SWITCH QUI TE FAIS CHOISIR TON ATTAQUE AVEC i-1 POUR CHOISIR SON ATTAQUE
