package operations;

public class Operations {

    public static long additionner(long... valeurs) {

        if (valeurs.length < 2) {
            throw new ArithmeticException("Nombre d'arguments incorrect");
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
            throw new ArithmeticException("Nombre d'arguments incorrect");
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
            throw new ArithmeticException("Nombre d'arguments incorrect");
        }

        for (Long val: valeurs) {
            if (val == 0) {
                throw new ArithmeticException("Impossible de diviser par 0");
            }
        }

        long resultat = valeurs[0];

        for (int i = 1; i < valeurs.length; i++) {

            System.out.println("Valeur " + i + " : "+ valeurs[i]);
            resultat = resultat / valeurs[i];
        }

        System.out.println("Resultat final division : " + resultat + ".");
        return resultat;
    }

    public static  boolean pythagore(long cote1, long cote2, long cote3) {

        if (cote1 <= 0 || cote2 <= 0 || cote3 <= 0) {
            throw new ArithmeticException("Valeurs des côtés incorrectes");
        }

        long hypothenuse = 0;
        long premierCote = 0;
        long secondCote = 0;

        if (cote1 >= cote2) {
            hypothenuse = cote2;
            premierCote = cote1;
            secondCote = cote3;
        } else {
            hypothenuse = cote1;
            premierCote = cote2;
            secondCote = cote3;
        }

        if (cote3 > hypothenuse) {
            hypothenuse = cote3;
            premierCote = cote1;
            secondCote = cote2;
        }

        return premierCote * premierCote + secondCote * secondCote == hypothenuse * hypothenuse;
    }
}
