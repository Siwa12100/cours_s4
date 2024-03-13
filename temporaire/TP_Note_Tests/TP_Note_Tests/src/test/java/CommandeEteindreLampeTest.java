import org.example.CommandeEteindreLampe;
import org.example.Lampe;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandeEteindreLampeTest {

    @Test
    void testExecuter(){
        Lampe lampe = new Lampe("salon");

        CommandeEteindreLampe commandeEteindreLampe = new CommandeEteindreLampe(lampe);

        commandeEteindreLampe.executer();

        assertEquals(lampe.getNiveau(),0);
    }

    @Test
    void testAnnuler(){
        Lampe lampe = new Lampe("salon");
        CommandeEteindreLampe commandeEteindreLampe = new CommandeEteindreLampe(lampe);

        commandeEteindreLampe.annuler();

        assertEquals(100,lampe.getNiveau());

    }

}
