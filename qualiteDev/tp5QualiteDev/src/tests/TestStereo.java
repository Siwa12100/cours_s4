package tests;

import models.Stereo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestStereo {


    @Test
    @DisplayName("Test de l'instanciation")
    void testInstanciation(){
        Stereo stereo = new Stereo("Cuisine");
        assertNotNull(stereo);
        assertEquals("salon", stereo.getLocalisation());
    }
}
