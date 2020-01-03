package domein;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import persistentie2.SpelMapper;
import persistentie2.SpelerMapper;

/**
 * @author Bert Schouteere, Nick De Loor, Dzhem Aptula, Merijn Maene
 */

public class DaagUit
{
    UitdaagRepository ur = new UitdaagRepository();
//test
    
    public static void main(String args[]) {
        System.out.println("Test fase begint, stand clear of loading dock");
    }
    public void gewonnenUitdaging(int id,int id2, int aantalPogingen, int moeilijkheidsgraad){
        ur.gewonnenUitdaging(id, id2, aantalPogingen, moeilijkheidsgraad);
    }
}
