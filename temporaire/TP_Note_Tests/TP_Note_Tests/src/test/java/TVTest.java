import org.example.TV;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TVTest {


    @Test
    void testInit() {
        TV tV = new TV("salon");

        assertEquals(0, tV.getCanal());
        assertEquals("salon", tV.getLocalisation());
    }

    @Test
    void testCanal() {
        TV tV = new TV("salon");
        tV.selectionnerCanal();
        assertEquals(3, tV.getCanal());
    }

    @Test
    void testState() {
        TV tV = new TV("salon");
        assertTrue(tV.isOn());
    }

    @Test
    void testStateOff() {
        TV tV = new TV("salon");
        tV.arret();
        assertFalse(tV.isOn());
    }

    @Test
    void testStateOn() {
        TV tV = new TV("salon");

        tV.arret();
        assertFalse(tV.isOn());

        tV.marche();
        assertTrue(tV.isOn());
    }


    @Test
    void testArret(){
        TV tV = new TV("salon");
        tV.arret();
        assertFalse(tV.isOn());
    }

    @Test
    void testMarche(){
        TV tV = new TV("salon");
        tV.marche();
        assertTrue(tV.isOn());
    }
}
