package tests;

import models.Lampe;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LampeTest {


    @Test
    @DisplayName("Test de l instanciation")
    void testInstanciation(){

        Lampe lampe = new Lampe("Cuisine");

        assertEquals(0, lampe.getNiveau());
        assertEquals("salon", lampe.getLocalisation());
        assertNotNull(lampe);

    }

    @Test
    @DisplayName("Test lampe arrêt")
    void testArret(){
        Lampe lampe = new Lampe("Cuisine");
        lampe.arret();
        assertEquals(0, lampe.getNiveau());
    }

    @Test
    @DisplayName("Test lampe marche")
    void testMarche(){

        Lampe lampe = new Lampe("Cuisine");
        lampe.marche();
        assertEquals(100, lampe.getNiveau());
    }

    @Test
    @DisplayName("Test de atténuer")
    void testAttenuer(){
        Lampe lampe = new Lampe("Cuisine");
        lampe.attenuer(19);
        assertEquals(19, lampe.getNiveau());
    }

    @Test
    @DisplayName("Test du GetNiveau")
    void testGetNiveau(){
        Lampe lampe = new Lampe("Cuisine");
        lampe.attenuer(89);
        assertEquals(89, lampe.getNiveau());
    }
}
