public class Deck {
    Attaque foudre = new Attaque("Foudre", "Envoie une décharge éléctrique à l'adversaire", 10),
            flamme = new Attaque("Flamme", "Lance une flamme sur l'adversaire", 10),
            jet_eau = new Attaque("Jet d'eau", "Envoie un jet d'eau sur l'adversaire", 10);
    Pokemon Pikachu = new Pokemon("Pikachu", 1, 100,"Electricité", foudre),
            Salameche = new Pokemon("Salamèche", 1, 100, "Feu", flamme),
            Carapuce = new Pokemon("Carapuce", 1, 100, "Eau", jet_eau);




}
