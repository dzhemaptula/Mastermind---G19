/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.security.DomainCombiner;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import static javafx.scene.layout.GridPane.setHalignment;
import taal.Taal;
import domein.DomeinController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

/**
 *
 * @author dzhem
 */
public class Menu extends GridPane
{

    public Menu(DomeinController dc, HoofdScherm hs)
    {
        
        this.setAlignment(Pos.CENTER);
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(25, 25, 25, 25));
        
        /* Aantal uitdagingen */
        Label lblAantalUitdagingen = new Label(Taal.geefString("guiAantalBeschikbareUitdagingen") + dc.openstaandeUitdagingen(dc.getSpelerId(dc.getSpelersNaam())));
        setHalignment(lblAantalUitdagingen,HPos.LEFT);
        this.add(lblAantalUitdagingen, 4, 0);
        
        /* Start nieuw spel */
        Button btnNewGame = new Button(Taal.geefString("guiNewGame"));
        setHalignment(btnNewGame, HPos.LEFT);
        this.add(btnNewGame, 2, 0);
        
        /* Laad spel op */
        Button btnLoadGame = new Button(Taal.geefString("guiLoadGame"));
        setHalignment(btnLoadGame, HPos.LEFT);
        this.add(btnLoadGame, 2, 1);
        
        /* Daag iemand uit */
        Button btnChallengeSomeone = new Button(Taal.geefString("guiChallengeSomeone"));
        setHalignment(btnChallengeSomeone, HPos.LEFT);
        this.add(btnChallengeSomeone, 2, 2);
        Button btnLogout = new Button(Taal.geefString("guiLogout"));
        setHalignment(btnLogout, HPos.LEFT);
        this.add(btnLogout, 2, 5);
        Button btnAcceptChallenge = new Button(Taal.geefString("guiAcceptChallenge"));
        if (dc.openstaandeUitdagingen(dc.getSpelerId(dc.getSpelersNaam())) > 0)
        {
            setHalignment(btnAcceptChallenge, HPos.LEFT);
            this.add(btnAcceptChallenge, 2, 3);
        }
        
        /* Toon klassement */
        Button btnKlassement = new Button(Taal.geefString("guiKlassement"));
        setHalignment(btnKlassement, HPos.LEFT);
        this.add(btnKlassement, 2, 4);
        
        /* Nieuw spel button actie */
        btnNewGame.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                hs.toonMoeilijkheidscherm();
            }
        });
        
        /* Logout button actie */
        btnLogout.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                hs.toonLoginScherm();
            }
        });
        
        /* Klassement button actie */
        btnKlassement.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                hs.toonKlassementScherm();
            }
        });
        /* LoadGame button actie */
        btnLoadGame.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                hs.toonLaadOpScherm();
            }
        });
         /* ChallengeSomeone button actie */
        btnChallengeSomeone.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                hs.toonDaagUitScherm();
            }
        });
        btnAcceptChallenge.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                hs.toonBekijkUitdagingen();
            }
        });
        /* AcceptChallenge button actie */
//        btnAcceptChallenge.setOnAction(new EventHandler<ActionEvent>()
//        {
//            @Override
//            public void handle(ActionEvent event)
//            {
//                hs.toonAanvaardUitdagingScherm();
//            }
//        });
    }
    
}
