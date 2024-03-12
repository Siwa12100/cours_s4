package tests;

import models.TV;
import models.Ventilateur;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TvTest {


    @Test
    @DisplayName("test de l'instanciation")
    void testInstanciation() {

        TV tv = new TV("salon");

        assertEquals(0, tv.getCanal());
        assertEquals("salon", tv.getLocalisation());
    }

    @Test
    @DisplayName("Test de la sélection d'un canal")
    void testSelectionnerCanal() {

        TV tv = new TV("Cuisine");
        tv.selectionnerCanal();

        assertEquals(3, tv.getCanal());
    }

    @Test
    @DisplayName("Test de getLocalisation")
    void testGetLocalisation() {
        TV tv = new TV("Cuisine");

        assertEquals("Cuisine", tv.getLocalisation());
    }

}
