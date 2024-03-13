import org.example.CommandeAllumerJacuzzi;
import org.example.Jacuzzi;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CommandeAllumerJaccuziTest {


    @Test
    public void testInit(){


        Jacuzzi j = new Jacuzzi();
        CommandeAllumerJacuzzi commandeAllumerJaccuzi = new CommandeAllumerJacuzzi(j);

        commandeAllumerJaccuzi.executer();

        assertEquals(j.getTemperature(),100);
        assertTrue(j.isAllume());

    }

    @Test
    public void testAnnuler(){
        Jacuzzi j = new Jacuzzi();
        CommandeAllumerJacuzzi commandeAllumerJaccuzi = new CommandeAllumerJacuzzi(j);

        commandeAllumerJaccuzi.annuler();

        assertFalse(j.isAllume());
    }
}
