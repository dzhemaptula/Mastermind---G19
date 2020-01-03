/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domein;
import java.util.List;
import persistentie2.SpelMapper;
/**
 *
 * @author dzhem
 */
public class SpelRepository
{
    SpelMapper myMapper = new SpelMapper();
    public boolean bestaatNaam(String naam){
        return myMapper.bestaatNaam(naam);
    }
    public void slaSpelOp(String spelernaam, String naam, String spelbordstring, String juistePogingenString, String teKrakenString, int moeilijkheidsgraad, int aantalPogingen){
        myMapper.slaSpelOp(spelernaam, naam, spelbordstring, juistePogingenString, teKrakenString, moeilijkheidsgraad, aantalPogingen);
    }
    public List<String> getBewaardeSpellen(String spelernaam)
    {
        return myMapper.getBewaardeSpellen(spelernaam);
    }
    public List<String> laadSpelOp(int spelid){
        return myMapper.laadSpelOp(spelid);
    }
    public void verwijderSpel(int spelid)
    {
        myMapper.verwijderSpel(spelid);
    }
}
