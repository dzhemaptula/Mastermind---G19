/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dzhem
 */
public class SpelerTest
{
    
    public SpelerTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of setGewonnenSpelletjes method, of class Speler.
     */
    @Test
    public void testSetGewonnenSpelletjes()
    {
        System.out.println("setGewonnenSpelletjes");
        List<Integer> wins = null;
        Speler instance = new Speler();
        instance.setGewonnenSpelletjes(wins);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNaam method, of class Speler.
     */
    @Test
    public void testGetNaam()
    {
        System.out.println("getNaam");
        Speler instance = new Speler();
        String expResult = "";
        String result = instance.getNaam();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWachtwoord method, of class Speler.
     */
    @Test
    public void testGetWachtwoord()
    {
        System.out.println("getWachtwoord");
        Speler instance = new Speler();
        String expResult = "";
        String result = instance.getWachtwoord();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
