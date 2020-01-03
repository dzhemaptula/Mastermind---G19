package domein;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

public class OngeldigWachtwoordWachtwoordBev {

    private static final String geldigeNaam = "naam";
    private static final String geldigWachtwoord = "1abcdef2";

    @Test(expected = IllegalArgumentException.class)
    public void testVerschillendWachtwoord() {
        new Speler(geldigeNaam, geldigWachtwoord, "1abcdef3");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testVerschillendWachtwoordKleineGroteLetters() {
        new Speler(geldigeNaam, geldigWachtwoord, "1abCdef2");
    }

    @Test
    public void testDezelfdeWchtwoorden() {
        new Speler(geldigeNaam, geldigWachtwoord, "1abcdef2");
    }

}
