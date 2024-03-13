import org.example.CommandeAllumerTV;
import org.example.TV;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommandeAllumerTVTest {


    @Test
    public void testExecuter() {
        TV tv = new TV("salon");
        CommandeAllumerTV commande = new CommandeAllumerTV(tv);
        commande.executer();
        assertTrue(tv.isOn());
    }

    @Test
    public void testAnnuler() {
        TV tv = new TV("Salon");
        CommandeAllumerTV commande = new CommandeAllumerTV(tv);
        commande.executer();
        commande.annuler();
        assertFalse(tv.isOn());
    }

}
