import org.example.CommandeVentilateurRapide;
import org.example.Ventilateur;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommandeVentilateurRapideTest {

    @Test
    public void testInit(){

        Ventilateur v = new Ventilateur("salon");

        CommandeVentilateurRapide commandeVentilateurRapide = new CommandeVentilateurRapide(v);

        assertTrue(v instanceof Ventilateur);
    }

    @Test
    public void testExecuter(){

        Ventilateur v = new Ventilateur("salon");

        CommandeVentilateurRapide commandeVentilateurRapide = new CommandeVentilateurRapide(v);

        commandeVentilateurRapide.executer();

        assertEquals(v.getVitesse(), 3);

        assertEquals(commandeVentilateurRapide.getDerniereVitesse(), 0);
    }


    @Test
    public void testAnnuler(){

        Ventilateur v = new Ventilateur("salon");

        CommandeVentilateurRapide commandeVentilateurRapide = new CommandeVentilateurRapide(v);

        commandeVentilateurRapide.executer();

        commandeVentilateurRapide.annuler();

        assertEquals(v.getVitesse(), 0);
    }

    @Test
    public void testSetDerniereVitesse(){

        Ventilateur v = new Ventilateur("salon");

        CommandeVentilateurRapide commandeVentilateurRapide = new CommandeVentilateurRapide(v);

        commandeVentilateurRapide.setDerniereVitesse(2);

        assertEquals(commandeVentilateurRapide.getDerniereVitesse(), 2);
    }

    @Test
    void testDerniereVItesseIllegal(){
        Ventilateur v = new Ventilateur("salon");

        CommandeVentilateurRapide commandeVentilateurRapide = new CommandeVentilateurRapide(v);

        try {
            commandeVentilateurRapide.setDerniereVitesse(4);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "La vitesse doit être comprise entre 0 et 3");
        }
    }

    @Test
    void testDerniereVItesseIllegal2(){
        Ventilateur v = new Ventilateur("salon");

        CommandeVentilateurRapide commandeVentilateurRapide = new CommandeVentilateurRapide(v);

        try {
            commandeVentilateurRapide.setDerniereVitesse(-1);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "La vitesse doit être comprise entre 0 et 3");
        }
    }

    @Test
    void testAnnulerMOYEN(){
        Ventilateur v = new Ventilateur("salon");

        CommandeVentilateurRapide commandeVentilateurRapide = new CommandeVentilateurRapide(v);

        commandeVentilateurRapide.executer();

        commandeVentilateurRapide.setDerniereVitesse(2);

        commandeVentilateurRapide.annuler();

        assertEquals(v.getVitesse(), 2);
    }

    @Test
    void testAnnulerLENT(){
        Ventilateur v = new Ventilateur("salon");

        CommandeVentilateurRapide commandeVentilateurRapide = new CommandeVentilateurRapide(v);

        commandeVentilateurRapide.executer();

        commandeVentilateurRapide.setDerniereVitesse(1);

        commandeVentilateurRapide.annuler();

        assertEquals(v.getVitesse(), 1);
    }

    @Test
    void testAnnulerRapide(){
        Ventilateur v = new Ventilateur("salon");

        CommandeVentilateurRapide commandeVentilateurRapide = new CommandeVentilateurRapide(v);

        commandeVentilateurRapide.executer();

        commandeVentilateurRapide.setDerniereVitesse(3);

        commandeVentilateurRapide.annuler();

        assertEquals(v.getVitesse(), 3);
    }

}
