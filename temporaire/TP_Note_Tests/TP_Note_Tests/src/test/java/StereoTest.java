import org.example.Stereo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StereoTest {


    @Test
    void testConstructor(){
        Stereo stereo = new Stereo("salon");
        assertEquals(0, stereo.getVolume());
        assertEquals("salon", stereo.getLocalisation());

    }

    @Test
    void testSetVolumeShouldWorks(){
        Stereo stereo = new Stereo("salon");


        for(int i = 1; i <= 11; i++){
            stereo.setVolume(i);
            assertEquals(i, stereo.getVolume());
        }
    }

    @Test
    void testSetVolumeShouldNotWorks(){
        Stereo stereo = new Stereo("salon");

        stereo.setVolume(0);
        assertEquals(1, stereo.getVolume());

        stereo.setVolume(-10);
        assertEquals(1, stereo.getVolume());

        stereo.setVolume(12);
        assertEquals(11, stereo.getVolume());

        stereo.setVolume(20);
        assertEquals(11, stereo.getVolume());
    }

    @Test
    void testMarche(){
        Stereo stereo = new Stereo("salon");
        stereo.marche();
        assertEquals(true, stereo.isOn());
    }

    @Test
    void testArret(){
        Stereo stereo = new Stereo("salon");
        stereo.marche();
        stereo.arret();
        assertEquals(false, stereo.isOn());
    }
}
