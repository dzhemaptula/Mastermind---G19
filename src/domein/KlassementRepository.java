/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import persistentie2.KlassementMapper;

/**
 *
 * @author berts
 */
public class KlassementRepository
{

    KlassementMapper myMapper = new KlassementMapper();

    public int[][] toonKlassement()
    {
        return myMapper.toonKlassement();
    }

    public void verhoogWins(int spelerid)
    {
        myMapper.verhoogWins(spelerid);
    }

    public void verhoogLosses(int spelerid)
    {
        myMapper.verhoogLosses(spelerid);
    }

    public void verlaagWins(int spelerid)
    {
        myMapper.verlaagWins(spelerid);
    }

    public void verlaagLosses(int spelerid)
    {
        myMapper.verlaagLosses(spelerid);
    }
}
