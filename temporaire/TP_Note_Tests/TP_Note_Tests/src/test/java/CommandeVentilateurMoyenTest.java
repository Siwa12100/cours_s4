import org.example.CommandeVentilateurMoyen;
import org.example.Ventilateur;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommandeVentilateurMoyenTest {


    @Test
    void testInit(){

        Ventilateur v = new Ventilateur("salon");

        CommandeVentilateurMoyen CommandeVentilateurMoyen = new CommandeVentilateurMoyen(v);

        assertTrue(v instanceof Ventilateur);
    }

    @Test
    void testExecuter(){

        Ventilateur v = new Ventilateur("salon");

        CommandeVentilateurMoyen CommandeVentilateurMoyen = new CommandeVentilateurMoyen(v);

        CommandeVentilateurMoyen.executer();

        assertTrue(v.getVitesse() == 2);

        assertTrue(CommandeVentilateurMoyen.getDerniereVitesse() == 0);
    }
    
    @Test
    void testAnnuler(){

        Ventilateur v = new Ventilateur("salon");

        CommandeVentilateurMoyen CommandeVentilateurMoyen = new CommandeVentilateurMoyen(v);

        CommandeVentilateurMoyen.executer();

        CommandeVentilateurMoyen.annuler();

        assertTrue(v.getVitesse() == 0);
    }
    
    @Test
    void testSetDerniereVitesse(){

        Ventilateur v = new Ventilateur("salon");

        CommandeVentilateurMoyen CommandeVentilateurMoyen = new CommandeVentilateurMoyen(v);

        CommandeVentilateurMoyen.setDerniereVitesse(2);

        assertTrue(CommandeVentilateurMoyen.getDerniereVitesse() == 2);
    }

    @Test
    void testDerniereVitesseIllegal(){

        Ventilateur v = new Ventilateur("salon");

        CommandeVentilateurMoyen CommandeVentilateurMoyen = new CommandeVentilateurMoyen(v);

        try {
            CommandeVentilateurMoyen.setDerniereVitesse(4);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "La vitesse doit être comprise entre 0 et 3");
        }

        try {
            CommandeVentilateurMoyen.setDerniereVitesse(-1);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "La vitesse doit être comprise entre 0 et 3");
        }
    }

    @Test
    void testAnnulerMOYEN(){
        Ventilateur v = new Ventilateur("salon");

        CommandeVentilateurMoyen CommandeVentilateurMoyen = new CommandeVentilateurMoyen(v);

        CommandeVentilateurMoyen.executer();

        CommandeVentilateurMoyen.setDerniereVitesse(2);

        CommandeVentilateurMoyen.annuler();

        assertEquals(v.getVitesse(), 2);
    }

    @Test
    void testAnnulerLENT(){
        Ventilateur v = new Ventilateur("salon");

        CommandeVentilateurMoyen CommandeVentilateurMoyen = new CommandeVentilateurMoyen(v);

        CommandeVentilateurMoyen.executer();

        CommandeVentilateurMoyen.setDerniereVitesse(1);

        CommandeVentilateurMoyen.annuler();

        assertEquals(v.getVitesse(), 1);
    }

    @Test
    void testAnnulerRapide(){
        Ventilateur v = new Ventilateur("salon");

        CommandeVentilateurMoyen CommandeVentilateurMoyen = new CommandeVentilateurMoyen(v);

        CommandeVentilateurMoyen.executer();

        CommandeVentilateurMoyen.setDerniereVitesse(3);

        CommandeVentilateurMoyen.annuler();

        assertEquals(v.getVitesse(), 3);
    }
    

}
