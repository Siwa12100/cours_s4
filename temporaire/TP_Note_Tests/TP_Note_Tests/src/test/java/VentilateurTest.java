import org.example.Ventilateur;
import org.junit.jupiter.api.Test;

import static org.example.Ventilateur.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VentilateurTest {


    @Test
    void testInit(){
        Ventilateur ventilateur = new Ventilateur("salon");
        assertEquals(0, ventilateur.getVitesse());
        assertEquals("salon", ventilateur.getLocalisation());
    }

    @Test
    void testRapide(){
        Ventilateur ventilateur = new Ventilateur("salon");
        ventilateur.rapide();
        assertEquals(RAPIDE, ventilateur.getVitesse());
    }

    @Test
    void testMoyen(){
        Ventilateur ventilateur = new Ventilateur("salon");
        ventilateur.moyen();
        assertEquals(MOYEN, ventilateur.getVitesse());
    }

    @Test
    void testArreter(){
        Ventilateur ventilateur = new Ventilateur("salon");
        ventilateur.arreter();
        assertEquals(ARRET, ventilateur.getVitesse());
    }

    @Test
    void testLent(){
        Ventilateur ventilateur = new Ventilateur("salon");
        ventilateur.lent();
        assertEquals(LENT, ventilateur.getVitesse());
    }

    @Test
    void testGetVitesse(){
        Ventilateur ventilateur = new Ventilateur("salon");
        assertEquals(0, ventilateur.getVitesse());
        ventilateur.rapide();
        assertEquals(RAPIDE, ventilateur.getVitesse());
    }

}
