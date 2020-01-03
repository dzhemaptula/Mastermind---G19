package domein;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Speler
{
    private SpelerRepository sr = new SpelerRepository();
    private String naam, wachtwoord;
    private List<Integer> gewonnenSpelletjes = new ArrayList<>();

    public Speler(String naam, String wachtwoord)
    {
        setNaam(naam);
        setWachtwoord(wachtwoord);
    }

    public Speler(String naam, String wachtwoord, String wachtwoordbevestiging)
    {
        if(sr.bestaatSpeler(naam))
            throw new IllegalArgumentException("naamBestaat");
        if (!wachtwoord.equals(wachtwoordbevestiging))
        {
            throw new IllegalArgumentException("wwOngelijk");
        }
        this.setWachtwoord(wachtwoord);
        this.setNaam(naam);
    }

    //private setNaam
    public void setGewonnenSpelletjes(List<Integer> wins)
    {
        this.gewonnenSpelletjes = wins;
    }

    private List<Integer> getGewonnenSpelletjes()
    {
        return this.gewonnenSpelletjes;//getGewonnenSpelletjes retourneert List<int> van de gewonnen spelletjes
        //bv: op plaats 0 staat een int van makkelijkeWins, 1 = normaal enz.
    }

    private void setNaam(String naam)
    {

        if (naam == null || naam.trim().isEmpty()) 
       {
            throw new IllegalArgumentException("naamLeeg");
        }
        this.naam = naam;
    }

    private void setWachtwoord(String wachtwoord)
    {

        if (!wachtwoord.matches("[0-9][a-zA-Z]{6,}+[0-9]"))
        {
            throw new IllegalArgumentException("wwVoorwaarden");
        }
        this.wachtwoord = wachtwoord;
    }

    public String getNaam()
    { //naam van de property
        return naam;
    }

    //protected String getWachtwoord
    protected String getWachtwoord()
    {
        return this.wachtwoord;
    }

    protected void wisWachtwoord()
    { 
        this.wachtwoord = null;
    }

    public Speler()
    {
    }
    public void gewonnenSpel(int moeilijkheidsgraad){
        sr.gewonnenSpel(moeilijkheidsgraad, naam);
    }
    public List<String> geefSpelers(String naam){
        return sr.geefSpelers(naam);
    }
    public int getSpelerId(String naam){
        return sr.getSpelerId(naam);
    }
    public boolean bestaatSpelerById(int id){
        return sr.bestaatSpelerById(id);
    }
}
