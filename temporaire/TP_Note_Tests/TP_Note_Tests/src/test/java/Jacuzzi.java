import org.example.Jacuzzi;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestJacuzzi {


    @Test
    void testConstructor(){
        Jacuzzi jacuzzi = new Jacuzzi();

        assertTrue(jacuzzi instanceof Jacuzzi);
    }

    @Test
    void testAllumer(){
        Jacuzzi jacuzzi = new Jacuzzi();
        jacuzzi.allumer();
        assertTrue(jacuzzi.isAllume());
    }

    @Test
    void testArret(){
        Jacuzzi jacuzzi = new Jacuzzi();
        jacuzzi.allumer();
        jacuzzi.eteindre();
        assertFalse(jacuzzi.isAllume());
    }

    @Test
    void testSetTemperature(){
        Jacuzzi jacuzzi = new Jacuzzi();
        jacuzzi.setTemperature(30);
        assertEquals(30, jacuzzi.getTemperature());
    }

    @Test
    void testSetTemperature2(){
        Jacuzzi jacuzzi = new Jacuzzi();
        jacuzzi.setTemperature(30);
        jacuzzi.setTemperature(20);
        assertEquals(20, jacuzzi.getTemperature());
    }

    @Test
    void testBouillonner(){
        Jacuzzi jacuzzi = new Jacuzzi();
        jacuzzi.allumer();
        jacuzzi.bouillonner();
        assertEquals(100, jacuzzi.getTemperature());
    }

}
