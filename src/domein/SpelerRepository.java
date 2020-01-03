package domein;
import java.util.ArrayList;
import java.util.List;
import persistentie2.SpelerMapper;

public class SpelerRepository
{
    SpelerMapper myMapper = new SpelerMapper();
    
    public SpelerRepository(){
        
    }
    public void voegToe(Speler sp){
            myMapper.registreer(sp.getNaam(), sp.getWachtwoord());
    }
    public boolean bestaatSpeler(String naam){
        return myMapper.bestaatSpeler(naam);
    }
    public boolean bestaatSpelerById(int id){
        return myMapper.bestaatSpelerById(id);
    }
    public Speler meldAan(String naam, String wachtwoord) {
        return myMapper.logIn(naam, wachtwoord);
    }
    /*
    public void voegToe(Speler speler) {
        if(myMapper.registreer(speler.getGebruikersnaam(), wachtwoord)){
            
        }
    }*/
    public List<Integer> getGewonnenSpelletjes(String naam){
        return myMapper.getGewonnenSpelletjes(naam);
    }
    //UC2 nog te doen
    
    public List<String> getMoeilijkheidsgraadMenu(List<Integer> wins){
        List<String> res = new ArrayList<>();
        res.add(""+Moeilijkheidsgraad.getMoelijkheidsgraad(1));
        int makkelijkWins = wins.get(0);
        int normaalWins = wins.get(1);
        if(makkelijkWins>=20){
            res.add(""+Moeilijkheidsgraad.getMoelijkheidsgraad(2));
        }
        if(normaalWins>=20){
            res.add(""+Moeilijkheidsgraad.getMoelijkheidsgraad(3));
        }
        return res;
    }
    public int getSpelerId(String spelerNaam){
        return myMapper.getSpelerId(spelerNaam);
    }
    public void gewonnenSpel(int moeilijkheidsgraad,String spelernaam){
        myMapper.gewonnenSpelletje(moeilijkheidsgraad, spelernaam);
    }
    public List<String> geefSpelers(String naam){
        return myMapper.geefSpelers(naam);
    }
    public String getSpelerNaamById(int id){
        return myMapper.getSpelerNaamById(id);
    }
}
