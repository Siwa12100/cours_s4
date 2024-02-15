package fibonacci;

import java.util.*;

public class Fibonacci {

    private int valeurInitiale;
    private List<Integer> listeValeurs;

    public Fibonacci() {
        this.valeurInitiale = 0;
        this.listeValeurs = new ArrayList<>();
        this.listeValeurs.add(this.valeurInitiale);
    }

    private int calculProchaineValeur(int position) {

        if (position == 0) {
            return 1;
        }
        int resultat = this.listeValeurs.get(position) + this.listeValeurs.get(position + 1);
        return resultat;
    }
    public int calculFibonacci(int position) {

        if (this.listeValeurs.size() < position + 1) {
            int cpt = 0;
            while (cpt < position) {
                this.listeValeurs.add(this.calculProchaineValeur(cpt));
                cpt++;
            }
        }

        return this.listeValeurs.get(position);
    }
}
