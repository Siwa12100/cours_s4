import org.example.CommandeEteindreTV;
import org.example.TV;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommandeEteindreTVTest {

    @Test
    public void testInit(){

        TV tv = new TV("salon");

        CommandeEteindreTV commandeEteindreTV = new CommandeEteindreTV(tv);

        assertTrue(tv instanceof TV);
        assertTrue(commandeEteindreTV instanceof CommandeEteindreTV);
    }

    @Test
    public void testExecuter(){

        TV tv = new TV("salon");

        CommandeEteindreTV commandeEteindreTV = new CommandeEteindreTV(tv);

        commandeEteindreTV.executer();

        assertFalse(tv.isOn());
    }

    @Test
    void testAnnuler(){

        TV tv = new TV("salon");

        CommandeEteindreTV commandeEteindreTV = new CommandeEteindreTV(tv);

        commandeEteindreTV.executer();

        commandeEteindreTV.annuler();

        assertTrue(tv.isOn());
    }



}
