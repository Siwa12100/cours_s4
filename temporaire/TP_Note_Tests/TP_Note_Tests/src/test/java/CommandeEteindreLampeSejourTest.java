import org.example.CommandeEteindreLampeSejour;
import org.example.Lampe;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommandeEteindreLampeSejourTest {

    @Test
    public void TestExecuter(){
        Lampe lampe = new Lampe("salon");

        CommandeEteindreLampeSejour commandeEteindreLampeSejour = new CommandeEteindreLampeSejour(lampe);

        commandeEteindreLampeSejour.executer();
        assertEquals(lampe.getNiveau(), 100);
    }

    @Test
    public void TestAnnuler(){
        Lampe lampe = new Lampe("salon");

        CommandeEteindreLampeSejour commandeEteindreLampeSejour = new CommandeEteindreLampeSejour(lampe);

        commandeEteindreLampeSejour.annuler();
        assertEquals(lampe.getNiveau(), 0);
    }
}
