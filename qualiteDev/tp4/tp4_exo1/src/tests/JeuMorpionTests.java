package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test du jeu Morpion")
public class JeuMorpionTests {

    @Test
    public void testCaseNonVide() {

        Jeu j = new Jeu();
        j.remplirCase(2, 2);
        assertEquals(true, j.isCaseRemplie(2, 2));
    }

    @Test
    public void testCaseVide() {

        Jeu j = new Jeu();
        //j.remplirCase(2, 2);
        assertEquals(false, j.isCaseRemplie(1, 2));
    }

    @Test
    public void testJeuRempli() {

        Jeu j = new Jeu();

        for (int i = 0; i < 3; i++) {
            j.remplirCase(i, 0);
            j.remplirCase(i, 1);
            j.remplirCase(i, 2);
        }

        assertEquals(true, j.isJeuRempli());
    }

    @Test
    public void testJeuNonRempli() {
        Jeu j = new Jeu();
        assertEquals(false, j.isJeuRempli());
    }

    @Test
    public void testJoueurGagnant() {
        Joueur j1 = new Joueur("Joueur 1");
        Joueur j2 = new Joueur("Joueur 2");
        Jeu j = new Jeu(j1, j2);

        j.remplirCase(0, 0, j1);
        j.remplirCase(0, 1, j1);
        j.remplirCase(0, 2, j1);

        assertEquals(true, j.isJoueurGagnant(j1));
    }

    @Test
    public void testJoueurNonGagnant() {
        Joueur j1 = new Joueur("Joueur 1");
        Joueur j2 = new Joueur("Joueur 2");
        Jeu j = new Jeu(j1, j2);

        j.remplirCase(0, 0, j1);
        j.remplirCase(0, 1, j1);

        assertEquals(false, j.isJoueurGagnant(j1));
    }
}
