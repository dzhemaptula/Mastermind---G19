/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;
import java.util.List;
import persistentie2.UitdaagMapper;
/**
 *
 * @author berts
 */
public class UitdaagRepository
{
    UitdaagMapper myMapper = new UitdaagMapper();
    public void gewonnenUitdaging(int id, int id2, int aantalPogingen, int moeilijkheidsgraad){
        myMapper.gewonnenUitdaging(id, id2, aantalPogingen, moeilijkheidsgraad);
    }
    public int openstaandeUitdagingen(int id) {
        return myMapper.openstaandeUitdagingen(id);
    }
    
    public List<String> toonUitdagingen(int id) {
        return myMapper.toonUitdagingen(id);
    }
    public boolean bestaatUitdaging(int id, int spelerid){
        return myMapper.bestaatUitdaging(id, spelerid);
    }
    public int getUitdagingMoeilijkheid(int id){
        return myMapper.getUitdagingMoeilijkheid(id);
    }
    public void gewonnenGeaccepteerdeUitdaging(int id, int aantalPogingen){
        myMapper.gewonnenGeaccepteerdeUitdaging(id, aantalPogingen);
    }
    public int getTegenStanderIdByUitdagingId(int id) {
        return myMapper.getTegenStanderIdByUitdagingId(id);
    }
    public int getTegenstanderScore(int gekozenuitdagingid) {
        return myMapper.getTegenstanderScore(gekozenuitdagingid);
    }
}
