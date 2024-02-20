import modele.AnalyseurFichierTexte;

import static modele.AnalyseurFichierTexte.analyserFichiersDansRepertoire;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        AnalyseurFichierTexte.analyserFichiersDansRepertoire("/data");
    }
}