package modele;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AnalyseurFichierTexte {

    public static void analyserFichiersDansRepertoire(String cheminRepertoire) {
        File repertoire = new File(cheminRepertoire);

        if (!repertoire.exists() || !repertoire.isDirectory()) {
            System.out.println("Le dossier spécifié n'existe pas ou n'est pas un répertoire.");
            return;
        }

        File[] fichiers = repertoire.listFiles((dir, name) -> name.toLowerCase().endsWith(".txt"));

        if (fichiers == null || fichiers.length == 0) {
            System.out.println("Aucun fichier texte trouvé dans le répertoire spécifié.");
            return;
        }

        for (File fichier : fichiers) {
            Map<Character, Integer> occurrencesCaracteres = compterOccurrencesLettres(fichier);

            if (occurrencesCaracteres != null) {
                afficherResultats(fichier.getName(), occurrencesCaracteres);
            }
        }
    }

    public static Map<Character, Integer> compterOccurrencesLettres(File fichier) {
        Map<Character, Integer> occurrencesCaracteres = new HashMap<>();

        try (BufferedReader lecteur = new BufferedReader(new FileReader(fichier))) {
            String ligne;

            while ((ligne = lecteur.readLine()) != null) {
                ligne = ligne.replaceAll("[^a-zA-Z]", "").toLowerCase();

                for (char caractere : ligne.toCharArray()) {
                    occurrencesCaracteres.put(caractere, occurrencesCaracteres.getOrDefault(caractere, 0) + 1);
                }
            }

        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + fichier.getName());
            return null;
        }

        return occurrencesCaracteres;
    }

    public static void afficherResultats(String nomFichier, Map<Character, Integer> occurrencesCaracteres) {
        System.out.print("{'" + nomFichier + "':" + occurrencesCaracteres.values().stream().mapToInt(Integer::intValue).sum());

        occurrencesCaracteres.forEach((cle, valeur) ->
                System.out.print(", '" + cle + "':" + valeur));

        System.out.println("}");
    }
}
