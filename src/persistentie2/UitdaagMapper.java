/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistentie2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import domein.UitdaagRepository;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author berts
 */
public class UitdaagMapper {
    // init connection object

    private Connection connection;

    // connect database
    public Connection connect() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(Connectie.JDBC_URL);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    // disconnect database
    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void gewonnenUitdaging(int id, int id2, int aantalPogingen, int moeilijkheidsgraad) {
        //INSERT INTO `ID222177_g19`.`speler` (`naam`, `wachtwoord`) VALUES ('test', 'test');
        try {
            Statement myStmt = this.connect().createStatement();
            // the mysql insert statement
            String query = "INSERT INTO `ID222177_g19`.`uitdaging` (`speler1`, `speler2`, `score1`, `score2`, `moeilijkheid`) VALUES ('" + id + "', '" + id2 + "', '" + aantalPogingen + "', '0', '" + moeilijkheidsgraad + "');";
            myStmt.executeUpdate(query);
            // create the mysql insert preparedstatement

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
    public void gewonnenGeaccepteerdeUitdaging(int id, int aantalPogingen) {
        //INSERT INTO `ID222177_g19`.`speler` (`naam`, `wachtwoord`) VALUES ('test', 'test');
        try {
            Statement myStmt = this.connect().createStatement();
            // the mysql insert statement
            String query = "UPDATE `ID222177_g19`.`uitdaging` SET `score2`="+aantalPogingen+" WHERE `id`="+id+";";
            myStmt.executeUpdate(query);
            // create the mysql insert preparedstatement

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

    public List<String> toonUitdagingen(int id) {
        List<String> result = new ArrayList<>();
        try {
            //maak statement
            Statement myStmt = this.connect().createStatement();
            //maak result sql
            ResultSet myRs = myStmt.executeQuery("SELECT id, speler1, speler2, score1, score2 FROM ID222177_g19.uitdaging WHERE speler2 =" + id + " AND score2=0;");
            //  WHERE speler.normaalWins > '20'
            while (myRs.next()) {
                // variable voor de naam
                String naam = toonSpelersNaamViaID(Integer.parseInt(myRs.getString("speler1")));
                result.add(myRs.getString("id") + ": " + naam + " met score " + myRs.getString("score1"));
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return result;
    }

    public String toonSpelersNaamViaID(int id) {
        String result = "";

        try {
            // SQL statement 
            Statement myStmt = this.connect().createStatement();
            // Result SQL
            ResultSet myRs = myStmt.executeQuery("SELECT naam FROM ID222177_g19.speler WHERE id = " + id);

            while (myRs.next()) {
                result = myRs.getString("naam");
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return result;
    }

    public int openstaandeUitdagingen(int id) {

        int result = 0;

        try {
            // SQL statement 
            Statement myStmt = this.connect().createStatement();
            // Result SQL
            ResultSet myRs = myStmt.executeQuery("SELECT count(*) FROM ID222177_g19.uitdaging WHERE score2=0 AND speler2=" + id);

            while (myRs.next()) {
                result = myRs.getInt("count(*)");
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return result;
    }

    public boolean bestaatUitdaging(int id, int spelerid) {
        try {
            // SQL statement 
            Statement myStmt = this.connect().createStatement();
            // Result SQL
            ResultSet myRs = myStmt.executeQuery("SELECT count(*) FROM ID222177_g19.uitdaging WHERE id = " + id+ " AND speler2 = " + spelerid);

            while (myRs.next()) {
                if (myRs.getInt("count(*)") == 0) {
                    return false;
                }
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return true;
    }
    public int getUitdagingMoeilijkheid(int id) {
        int result=0;
        try {
            // SQL statement 
            Statement myStmt = this.connect().createStatement();
            // Result SQL
            ResultSet myRs = myStmt.executeQuery("SELECT moeilijkheid FROM ID222177_g19.uitdaging WHERE id = " + id);
            while (myRs.next()) {
               result = myRs.getInt("moeilijkheid");
            }
            myStmt.executeUpdate("UPDATE `ID222177_g19`.`uitdaging` SET `score2`=12 WHERE id="+id);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return result;
    }
    public int getTegenStanderIdByUitdagingId(int id) {
        int result=0;
        try {
            // SQL statement 
            Statement myStmt = this.connect().createStatement();
            // Result SQL
            ResultSet myRs = myStmt.executeQuery("SELECT speler1 FROM ID222177_g19.uitdaging WHERE id = " + id);
            while (myRs.next()) {
               result = myRs.getInt("speler1");
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return result;
    }
    public int getTegenstanderScore(int gekozenuitdagingid) {
        int result=0;
        try {
            // SQL statement 
            Statement myStmt = this.connect().createStatement();
            // Result SQL
            ResultSet myRs = myStmt.executeQuery("SELECT score1 FROM ID222177_g19.uitdaging WHERE id = " + gekozenuitdagingid);
            while (myRs.next()) {
               result = myRs.getInt("score1");
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return result;
    }
}
