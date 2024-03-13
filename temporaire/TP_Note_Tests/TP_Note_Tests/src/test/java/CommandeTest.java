import org.example.CommandeAllumerLampe;
import org.example.Telecommande;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CommandeTest {


    @Test
    void testCommande(){


        Telecommande t = new Telecommande();

        assertTrue(t instanceof Telecommande);

    }
}
