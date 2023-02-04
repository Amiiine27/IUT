public class Pokemon {
    private String nom, type;
    private int niveau, pointVie;

    private Attaque attaque;

    public Pokemon(String n, int niv, int pv, String t, Attaque att){
        nom = n;
        niveau = niv;
        pointVie = pv;
        type = t;
        attaque = att;

    }


}
