import org.example.CommandeAllumerStereo;
import org.example.CommandeEteindreStereo;
import org.example.Stereo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandeEteindreStereoTest {


    @Test
    public void test() {
        Stereo stereo = new Stereo("salon");
        CommandeAllumerStereo commandeAllumerStereo = new CommandeAllumerStereo(stereo);
        CommandeEteindreStereo commandeEteindreStereo = new CommandeEteindreStereo(stereo);
        commandeAllumerStereo.executer();
        commandeEteindreStereo.executer();
        assertEquals(false, stereo.isOn());
    }

    @Test
    public void testAnnuler() {
        Stereo stereo = new Stereo("salon");
        CommandeAllumerStereo commandeAllumerStereo = new CommandeAllumerStereo(stereo);
        CommandeEteindreStereo commandeEteindreStereo = new CommandeEteindreStereo(stereo);
        commandeAllumerStereo.executer();
        commandeEteindreStereo.executer();
        commandeEteindreStereo.annuler();
        assertEquals(true, stereo.isOn());
    }



}
