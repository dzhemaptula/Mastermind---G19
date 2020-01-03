/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistentie2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dzhem
 */
public class SpelMapper
{
    // init connection object
    private Connection connection;

    // connect database
    public Connection connect()
    {
        if (connection == null)
        {
            try
            {
                connection = DriverManager.getConnection(Connectie.JDBC_URL);
            } catch (SQLException e)
            {
                e.printStackTrace();
            } 
        }
        return connection;
    }

    // disconnect database
    public void disconnect()
    {
        if (connection != null)
        {
            try
            {
                connection.close();
                connection = null;
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
    public void slaSpelOp(String spelernaam, String naam, String spelbord, String juistePogingen,  String teKrakenCode, int moeilijkheidsgraad, int rij)
    {
        //INSERT INTO `ID222177_g19`.`speler` (`naam`, `wachtwoord`) VALUES ('test', 'test');
        try
        {//SELECT id FROM ID222177_g19.speler where naam="test";
            Statement myStmt = this.connect().createStatement();
            // the mysql insert statement
            int id=0;
            ResultSet myRs = myStmt.executeQuery("SELECT id FROM ID222177_g19.speler where naam='"+spelernaam+"'");
            while (myRs.next())
            {
                id = myRs.getInt("id");
            }
            String query = "INSERT INTO ID222177_g19.bewaardespelletjes (spelerid, naam, spelbord, juistePogingen, teKrakenCode, moeilijkheidsgraad, rij) VALUES ('"+id+"', '"+naam+"','"+spelbord+"','"+juistePogingen+"','"+teKrakenCode+"','"+moeilijkheidsgraad+"','"+rij+"');";
            //throw new IllegalArgumentException(query);
            myStmt.executeUpdate(query);
            // create the mysql insert preparedstatement
            
            
        } catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
    public boolean bestaatNaam(String spelNaam)
    {
        int result = 0;
        try
        {
            // Maak statement
            Statement myStmt = this.connect().createStatement();
            // Maak result SQL
            
            ResultSet myRs = myStmt.executeQuery("SELECT count(*) FROM ID222177_g19.bewaardespelletjes WHERE naam = '" + spelNaam + "'");
            while (myRs.next())
            {
                result = myRs.getInt("count(*)");
            }
            if (result == 1)
            {
                return true;
            } else if (result == 0)
            {
                return false;
            } else
            {
                throw new java.lang.RuntimeException("Er is een error opgetreden in de Java mapper klasse bij de functie bestaatNaam. Bel de 100!");
            }
        } catch (Exception exc)
        {
            exc.printStackTrace();
        }
        return false;
    }
    public List<String> getBewaardeSpellen(String spelernaam)
    {
        List<String> result = new ArrayList<>();
        try
        {
            //maak statement
            Statement myStmt = this.connect().createStatement();
            int id=0;
            ResultSet myRs = myStmt.executeQuery("SELECT id FROM ID222177_g19.speler where naam='"+spelernaam+"'");
            while (myRs.next())
            {
                id = myRs.getInt("id");
            }
            //maak result sql
            myRs = myStmt.executeQuery("SELECT * FROM ID222177_g19.bewaardespelletjes where spelerid="+id+";");
            while (myRs.next())
            {
                result.add(myRs.getString("spelid") + ": " + myRs.getString("naam"));
            }
        } catch (Exception exc)
        {
            exc.printStackTrace();
        }
        return result;
    }
    public List<String> laadSpelOp(int spelid)
    {
        List<String> result = new ArrayList<>();
        try
        {
            //maak statement
            Statement myStmt = this.connect().createStatement();
            //maak result sql
            ResultSet myRs = myStmt.executeQuery("SELECT * FROM ID222177_g19.bewaardespelletjes WHERE spelid = '"+spelid+"';");
            
            while (myRs.next())
            {
                result.add(myRs.getString("spelbord"));
                result.add(myRs.getString("moeilijkheidsgraad"));
                result.add(myRs.getString("rij"));
                result.add(myRs.getString("teKrakenCode"));
                result.add(myRs.getString("juistePogingen"));
            }
        } catch (Exception exc)
        {
            exc.printStackTrace();
        }
        return result;
    }
    
    public void verwijderSpel(int spelid) {
        try
        {
            Statement myStmt = this.connect().createStatement();
            // the mysql insert statement
            String query = "DELETE FROM ID222177_g19.bewaardespelletjes WHERE spelid = " + spelid;
            //throw new IllegalArgumentException(query);
            myStmt.executeUpdate(query);
            // create the mysql insert preparedstatement
        } catch (SQLException ex)
        {
            Logger.getLogger(SpelMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
