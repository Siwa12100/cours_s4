package operations;

public class Operations {

    public static long additionner(long... valeurs) {

        if (valeurs.length < 2) {
            return -1;
        }

        long somme = 0;

        for (int i = 0; i < valeurs.length; i++) {
            //System.out.println("Valeur " + i + " : " + valeurs[i]);
            somme += valeurs[i];
        }
        //System.out.println("Somme finale : " + somme + ".");
        return somme;
    }

    public static long multiplier(long... valeurs) {

        if (valeurs.length < 2) {
            return -1;
        }

        long produit = 1;

        for (int i = 0; i < valeurs.length; i++) {
            //System.out.println("Valeur " + i + " : " + valeurs[i]);
            produit *= valeurs[i];
        }
        System.out.println("Produit final : " + produit + ".");
        return produit;
    }

    public static long diviser(long... valeurs) {

        if (valeurs.length < 2) {
            return -1;
        }

        long resultat = valeurs[0];

        for (int i = 1; i < valeurs.length; i++) {

            System.out.println("Valeur " + i + " : "+ valeurs[i]);
            resultat = resultat / valeurs[i];
        }

        System.out.println("Resultat final division : " + resultat + ".");
        return resultat;
    }
}
