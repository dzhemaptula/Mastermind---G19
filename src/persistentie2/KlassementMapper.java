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
import java.util.Arrays;

/**
 *
 * @author berts
 */
public class KlassementMapper
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
    public int[][] toonKlassement() {
        int[][] result=new int[1][1];
        try {
            //maak statement
            Statement myStmt = this.connect().createStatement();
            //maak result sql
            int aantalKlassements=0;
            ResultSet myRs = myStmt.executeQuery("SELECT count(*) FROM ID222177_g19.klassement");
            while (myRs.next()) {
                aantalKlassements=myRs.getInt("count(*)");
            }
            result = new int[aantalKlassements][4];
            myRs = myStmt.executeQuery("SELECT spelerid,wins,losses FROM ID222177_g19.klassement order by ((wins*3)-(losses)) desc");
            //  WHERE speler.normaalWins > '20'
            int teller=0;
            while (myRs.next()) {
                result[teller][0]=myRs.getInt("spelerid");
                result[teller][1]=myRs.getInt("wins");
                result[teller][2]=myRs.getInt("losses");
                teller++;
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        //
        return result;
    }
   
    public void verhoogWins(int spelerid){
        int wins=0;
        try{
            Statement myStmt = this.connect().createStatement();
            //maak result sql
            int aantalKlassements=0;
            ResultSet myRs = myStmt.executeQuery("SELECT wins FROM ID222177_g19.klassement WHERE `spelerid`="+spelerid+";");
            while (myRs.next()) {
                wins=myRs.getInt("wins");
            }
            wins++;
            myStmt.executeUpdate("UPDATE ID222177_g19.klassement SET `wins`="+wins+" WHERE `spelerid`="+spelerid+";");
        }catch(Exception exc){
            exc.printStackTrace();
        }
    }
    public void verhoogLosses(int spelerid){
        int losses=0;
        try{
            Statement myStmt = this.connect().createStatement();
            //maak result sql
            int aantalKlassements=0;
            ResultSet myRs = myStmt.executeQuery("SELECT losses FROM ID222177_g19.klassement WHERE `spelerid`="+spelerid+";");
            while (myRs.next()) {
                losses=myRs.getInt("losses");
            }
            losses++;
            myStmt.executeUpdate("UPDATE ID222177_g19.klassement SET `losses`="+losses+" WHERE `spelerid`="+spelerid+";");
        }catch(Exception exc){
            exc.printStackTrace();
        }
    }
    public void verlaagWins(int spelerid){
        int wins=0;
        try{
            Statement myStmt = this.connect().createStatement();
            //maak result sql
            int aantalKlassements=0;
            ResultSet myRs = myStmt.executeQuery("SELECT wins FROM ID222177_g19.klassement WHERE `spelerid`="+spelerid+";");
            while (myRs.next()) {
                wins=myRs.getInt("wins");
            }
            wins--;
            myStmt.executeUpdate("UPDATE ID222177_g19.klassement SET `wins`="+wins+" WHERE `spelerid`="+spelerid+";");
        }catch(Exception exc){
            exc.printStackTrace();
        }
    }
    public void verlaagLosses(int spelerid){
        int losses=0;
        try{
            Statement myStmt = this.connect().createStatement();
            //maak result sql
            int aantalKlassements=0;
            ResultSet myRs = myStmt.executeQuery("SELECT losses FROM ID222177_g19.klassement WHERE `spelerid`="+spelerid+";");
            while (myRs.next()) {
                losses=myRs.getInt("losses");
            }
            losses--;
            myStmt.executeUpdate("UPDATE ID222177_g19.klassement SET `losses`="+losses+" WHERE `spelerid`="+spelerid+";");
        }catch(Exception exc){
            exc.printStackTrace();
        }
    }
}
