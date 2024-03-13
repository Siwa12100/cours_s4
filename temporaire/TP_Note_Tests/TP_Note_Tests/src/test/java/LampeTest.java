import org.example.Lampe;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LampeTest {


    @Test
    void testConstructor(){
        Lampe lampe = new Lampe("salon");
        assertEquals(0, lampe.getNiveau());
        assertEquals("salon", lampe.getLocalisation());

    }


    @Test
    void testMarche(){
        Lampe lampe = new Lampe("salon");
        lampe.marche();
        assertEquals(100, lampe.getNiveau());
    }

    @Test
    void testArret(){
        Lampe lampe = new Lampe("salon");
        lampe.arret();
        assertEquals(0, lampe.getNiveau());
    }

    @Test
    void testAttenuer(){
        Lampe lampe = new Lampe("salon");
        lampe.attenuer(50);
        assertEquals(50, lampe.getNiveau());
    }

    @Test
    void testNiveau(){
        Lampe lampe = new Lampe("salon");
        assertEquals(0, lampe.getNiveau());
        lampe.attenuer(20);
        assertEquals(20, lampe.getNiveau());
    }

    @Test
    void testNiveauTo0(){
        Lampe lampe = new Lampe("salon");
        assertEquals(0, lampe.getNiveau());
        lampe.attenuer(150);
        assertEquals(150, lampe.getNiveau());
    }

    @Test
    void testAttenueAvecArret(){
        Lampe lampe = new Lampe("salon");
        lampe.attenuer(0);
        assertEquals(0, lampe.getNiveau());
    }


}
