package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import models.Ventilateur;

import static models.Ventilateur.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class VentilateurTest {


    @Test
    @DisplayName("Test de l'instanciation")
    void testInstantiation(){

        Ventilateur ventilateur = new Ventilateur("Cuisine");

        assertNotNull(ventilateur);
        assertEquals("Cuisine", ventilateur.getLocalisation());
        assertEquals(0, ventilateur.getVitesse());

    }

    @Test
    @DisplayName("Test d'arrêt")
    void testArreter(){
        Ventilateur ventilateur = new Ventilateur("Cuisine");

        ventilateur.arreter();
        assertEquals(ARRET, ventilateur.getVitesse());
    }

    @Test
    @DisplayName("Test de vitesse Lent")
    void testLent(){
        Ventilateur ventilateur = new Ventilateur("Cuisine");

        ventilateur.lent();
        assertEquals(LENT, ventilateur.getVitesse());
    }

    @Test
    @DisplayName("Test de vitesse moyen")
    void testMoyen(){
        Ventilateur ventilateur = new Ventilateur("Cuisine");

        ventilateur.moyen();
        assertEquals(MOYEN, ventilateur.getVitesse());
    }

    @Test
    @DisplayName("Test de vitesse rapide")
    void testRapide(){
        Ventilateur ventilateur = new Ventilateur("Cuisine");

        ventilateur.rapide();
        assertEquals(RAPIDE, ventilateur.getVitesse());
    }


    @Test
    @DisplayName("Test de getVitesse")
    void testGetVitesse(){
        Ventilateur ventilateur = new Ventilateur("Cuisine");

        assertEquals(0, ventilateur.getVitesse());
        ventilateur.rapide();
        assertEquals(RAPIDE, ventilateur.getVitesse());
    }

    @Test
    @DisplayName("Test de getLocalisation")
    void testGetLocalisation() {
        Ventilateur ventilateur = new Ventilateur("Cuisine");

        assertEquals("Cuisine", ventilateur.getLocalisation());
    }

}
