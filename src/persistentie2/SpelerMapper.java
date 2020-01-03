package persistentie2;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import domein.Speler;

public class SpelerMapper
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
    public boolean bestaatSpelerById(int id)
    {
        int result = 0;
        try
        {
            // Maak statement
            Statement myStmt = this.connect().createStatement();
            // Maak result SQL
            ResultSet myRs = myStmt.executeQuery("SELECT count(*) FROM ID222177_g19.speler WHERE id = '" + id + "'");
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
                throw new java.lang.RuntimeException("Er is een error opgetreden in de Java mapper klasse bij de functie bestaatSpeler. Bel de 100!");
            }
        } catch (Exception exc)
        {
            exc.printStackTrace();
        }
        return false;
    }
    
    public boolean bestaatSpeler(String spelerNaam)
    {
        int result = 0;
        try
        {
            // Maak statement
            Statement myStmt = this.connect().createStatement();
            // Maak result SQL
            ResultSet myRs = myStmt.executeQuery("SELECT count(*) FROM ID222177_g19.speler WHERE naam = '" + spelerNaam + "'");
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
                throw new java.lang.RuntimeException("Er is een error opgetreden in de Java mapper klasse bij de functie bestaatSpeler. Bel de 100!");
            }
        } catch (Exception exc)
        {
            exc.printStackTrace();
        }
        return false;
    }

    public Speler logIn(String spelerNaam, String wachtwoord)
    {
        boolean exists=false;
        try
        {
            // Maak statement
            Statement myStmt = this.connect().createStatement();
            // Maak result SQL
            ResultSet myRs = myStmt.executeQuery("SELECT EXISTS(SELECT * FROM ID222177_g19.speler WHERE naam = '" + spelerNaam + "' AND wachtwoord = '" + wachtwoord + "')  as result");
            if(myRs.next()){
                exists = myRs.getBoolean("result");
            }
            if (exists)
            {
                return new Speler(spelerNaam,wachtwoord);
            } else if (!exists)
            {
                return null;
            } else
            {
                throw new java.lang.RuntimeException("Er is een error opgetreden in de Java mapper klasse bij de functie bestaatSpeler. Bel de 100!");
            }
        } catch (Exception exc)
        {
            exc.printStackTrace();
        }
        return null;
    }
    
    public void registreer(String naam, String wachtwoord)
    {
        //INSERT INTO `ID222177_g19`.`speler` (`naam`, `wachtwoord`) VALUES ('test', 'test');
        try
        {
            Statement myStmt = this.connect().createStatement();
            // the mysql insert statement
            String query = "INSERT INTO ID222177_g19.speler (naam, wachtwoord) VALUES ('"+naam+"', '"+wachtwoord+"');";
            myStmt.executeUpdate(query);
            int id=this.getSpelerId(naam);
            query = "INSERT INTO `ID222177_g19`.`klassement` (`spelerid`, `wins`, `losses`) VALUES ('"+id+"', '0', '0');";
            myStmt.executeUpdate(query);
            // create the mysql insert preparedstatement
            
            
        } catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
    public List<Integer> getGewonnenSpelletjes(String spelerNaam)
    {
        List<Integer> result = new ArrayList<>();
        try
        {
            // Maak statement
            Statement myStmt = this.connect().createStatement();
            // Maak result SQL
            String sql = "SELECT * FROM ID222177_g19.speler WHERE naam = '" + spelerNaam + "'";
            ResultSet myRs = myStmt.executeQuery(sql);
            if(myRs.next()){
                result.add(myRs.getInt("makkelijkWins"));
                result.add(myRs.getInt("normaalWins"));
                result.add(myRs.getInt("moeilijkWins"));
            }
            
        } catch (Exception exc)
        {
            exc.printStackTrace();
        }
        return result;
    }
    public int getSpelerId(String spelerNaam)
    {
        try
        {
            // Maak statement
            Statement myStmt = this.connect().createStatement();
            // Maak result SQL
            String sql = "SELECT * FROM ID222177_g19.speler WHERE naam = '" + spelerNaam + "'";
            ResultSet myRs = myStmt.executeQuery(sql);
            while (myRs.next())
            {
                return myRs.getInt("id");
            }
            
        } catch (Exception exc)
        {
            exc.printStackTrace();
        }
        return 0;
    }
    public int gewonnenSpelletje(int moeilijkheidsgraad, String naam)
    {
        String sqlMoeilijk=null;
        if(moeilijkheidsgraad==1){
            sqlMoeilijk = "makkelijkWins";
        }
        else if(moeilijkheidsgraad==2){
            sqlMoeilijk = "normaalWins";
        }
        else if(moeilijkheidsgraad==3){
            sqlMoeilijk="moeilijkWins";
        }
        List<Integer> gewonnenSpelletjes = this.getGewonnenSpelletjes(naam);
        int gewonnenSpelletjesVanDeMoeilijkheidsgraad = gewonnenSpelletjes.get(moeilijkheidsgraad-1);
        gewonnenSpelletjesVanDeMoeilijkheidsgraad++;
        try
        {
            // Maak statement
            Statement myStmt = this.connect().createStatement();
            // Maak result SQL
            String sql = "UPDATE `ID222177_g19`.`speler` SET `"+sqlMoeilijk+"`='"+gewonnenSpelletjesVanDeMoeilijkheidsgraad+"' WHERE `naam`='"+naam+"'";
            myStmt.executeUpdate(sql);
            
        } catch (Exception exc)
        {
            exc.printStackTrace();
        }
        return 0;
    }
    
    public List<String> geefSpelers(String naam)
    {
        List<String> result = new ArrayList<>();
        try
        {
            //maak statement
            Statement myStmt = this.connect().createStatement();
            //maak result sql
            ResultSet myRs = myStmt.executeQuery("SELECT naam, id FROM ID222177_g19.speler");
            //  WHERE speler.normaalWins > '20'
            while (myRs.next())
            {
                if(!myRs.getString("speler.naam").equals(naam))
                result.add(myRs.getString("speler.id") + ": " +myRs.getString("speler.naam"));
            }
        } catch (Exception exc)
        {
            exc.printStackTrace();
        }
        return result;
    }
    
    public int geefSpelerId(String naam) {
        
        int result=0;
        
        try {
            // SQL statement 
            Statement myStmt = this.connect().createStatement();
            // Result SQL
            ResultSet myRs = myStmt.executeQuery("SELECT id FROM ID222177_g19.speler WHERE naam = " + naam);
            
            while (myRs.next()) {
                result = myRs.getInt("speler.id");
            }
        }
         catch (Exception exc) {
            exc.printStackTrace();
        }
        return result;
    }   
    public String getSpelerNaamById(int id){
        String result="";
        
        try {
            // SQL statement 
            Statement myStmt = this.connect().createStatement();
            // Result SQL
            ResultSet myRs = myStmt.executeQuery("SELECT naam FROM ID222177_g19.speler WHERE id = " + id);
            
            while (myRs.next()) {
                result = myRs.getString("speler.naam");
            }
        }
         catch (Exception exc) {
            exc.printStackTrace();
        }
        return result;
    }
}