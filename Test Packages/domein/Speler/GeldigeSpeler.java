package domein;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(value = Parameterized.class)
public class GeldigeSpeler {
    
    private String naam;
    private String wachtwoord;

    public GeldigeSpeler(String naam, String wachtwoord) {
        this.naam = naam;
        this.wachtwoord = wachtwoord;
    }

    @Parameterized.Parameters
    public static Collection<String[]> getTestParameters() {
        return Arrays.asList(new String[][]{
            {"naam", "1ABCDEF1"},
            {"NAAm", "2abCdeF2"}, {"NaA m", "3abcdeklsdjfdjjjflksdjlsdj2"},
            {"a c c c c", "5aZeRtYuIoPqS4"}, {"test*****", "8wxcvbn9"}
        });
    }

    @Test
    public void testGeldigeSpeler() {
        Speler speler = new Speler(naam, wachtwoord, wachtwoord);
        Assert.assertEquals(naam, speler.getNaam());
    }

    
}
