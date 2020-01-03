package domein;

import domein.Speler;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
    
@RunWith(value = Parameterized.class)
public class OngeldigSpeler {

    private String naam;
    private String wachtwoord;
    private static final String geldigWachtwoord = "1ABCDEF1";
    private static final String geldigeNaam = "naam";

    public OngeldigSpeler(String naam, String wachtwoord) {
        this.naam = naam;
        this.wachtwoord = wachtwoord;
    }

    @Parameterized.Parameters
    public static Collection<String[]> getTestParameters() {
        return Arrays.asList(new String[][]{
            {"  ", geldigWachtwoord},
            {"", geldigWachtwoord}, {null, geldigWachtwoord},
            {geldigeNaam, "ABCDEF1"}, {geldigeNaam, "1ABCDEF"},
            {geldigeNaam, "11"}, {geldigeNaam, "1ABCDE1"},
            {geldigeNaam, "abcdef1"}, {geldigeNaam, "1abcDEf"},
            {geldigeNaam, "2a2a2"}, {geldigeNaam, "5abcdfd22"},
            {geldigeNaam, "abcdef1"}, {geldigeNaam, "11abcDEf1"},
            {geldigeNaam, "2a2a2"}, {geldigeNaam, "1abcdef2a"},
            {geldigeNaam, "123abv223"}, {geldigeNaam, "1abc1cba1"},
            {geldigeNaam, "*abcdef*"}, {geldigeNaam, "1ab**ab1"},
            {"   ", "1ab**ab1"}
        });
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOngeldigeNaamWachtwoord() {
        new Speler(naam, wachtwoord, wachtwoord);
    }
    
}
