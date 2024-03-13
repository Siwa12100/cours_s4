import org.example.CommandeEteindreVentilateur;
import org.example.CommandeEteindreVentilateur;
import org.example.Ventilateur;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommandeEteindreVentilateurTest {


    @Test
    public void testInit(){

        Ventilateur v = new Ventilateur("salon");

        CommandeEteindreVentilateur commandeEteindreVentilateur = new CommandeEteindreVentilateur(v);

        assertTrue(v instanceof Ventilateur);
    }

    @Test
    public void testExecuter(){

        Ventilateur v = new Ventilateur("salon");

        CommandeEteindreVentilateur commandeEteindreVentilateur = new CommandeEteindreVentilateur(v);

        commandeEteindreVentilateur.executer();

        assertTrue(v.getVitesse() == 0);
    }

    @Test
    public void testAnnuler(){

        Ventilateur v = new Ventilateur("salon");

        CommandeEteindreVentilateur commandeEteindreVentilateur = new CommandeEteindreVentilateur(v);

        commandeEteindreVentilateur.executer();

        commandeEteindreVentilateur.annuler();

        assertTrue(v.getVitesse() == 0);
    }

    @Test
    void testSetDerniereVitesse(){

        Ventilateur v = new Ventilateur("salon");

        CommandeEteindreVentilateur CommandeEteindreVentilateur = new CommandeEteindreVentilateur(v);

        CommandeEteindreVentilateur.setDerniereVitesse(2);

        assertTrue(CommandeEteindreVentilateur.getDerniereVitesse() == 2);
    }

    @Test
    void testDerniereVitesseIllegal(){

        Ventilateur v = new Ventilateur("salon");

        CommandeEteindreVentilateur CommandeEteindreVentilateur = new CommandeEteindreVentilateur(v);

        try {
            CommandeEteindreVentilateur.setDerniereVitesse(4);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "La vitesse doit être comprise entre 0 et 3");
        }

        try {
            CommandeEteindreVentilateur.setDerniereVitesse(-1);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "La vitesse doit être comprise entre 0 et 3");
        }
    }

    @Test
    void testAnnulerMOYEN(){
        Ventilateur v = new Ventilateur("salon");

        CommandeEteindreVentilateur CommandeEteindreVentilateur = new CommandeEteindreVentilateur(v);

        CommandeEteindreVentilateur.executer();

        CommandeEteindreVentilateur.setDerniereVitesse(2);

        CommandeEteindreVentilateur.annuler();

        assertEquals(v.getVitesse(), 2);
    }

    @Test
    void testAnnulerLENT(){
        Ventilateur v = new Ventilateur("salon");

        CommandeEteindreVentilateur CommandeEteindreVentilateur = new CommandeEteindreVentilateur(v);

        CommandeEteindreVentilateur.executer();

        CommandeEteindreVentilateur.setDerniereVitesse(1);

        CommandeEteindreVentilateur.annuler();

        assertEquals(v.getVitesse(), 1);
    }

    @Test
    void testAnnulerRapide(){
        Ventilateur v = new Ventilateur("salon");

        CommandeEteindreVentilateur CommandeEteindreVentilateur = new CommandeEteindreVentilateur(v);

        CommandeEteindreVentilateur.executer();

        CommandeEteindreVentilateur.setDerniereVitesse(3);

        CommandeEteindreVentilateur.annuler();

        assertEquals(v.getVitesse(), 3);
    }

}
