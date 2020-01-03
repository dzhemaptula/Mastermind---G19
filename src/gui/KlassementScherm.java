package gui;

import javafx.scene.layout.GridPane;
import domein.DomeinController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import static javafx.scene.layout.GridPane.setHalignment;
import taal.Taal;

/**
 * @author Dzhem Aptula, Nick De Loor, Merijn Maene, Bert Schouteere
 */

public class KlassementScherm extends GridPane
{

    public KlassementScherm(DomeinController dc, HoofdScherm hs)
    {
        this.setAlignment(Pos.CENTER);
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(25, 25, 25, 25));

        int ranking = 1;
        int score = 0;
        for (int[] i : dc.toonKlassement())
        {
            score = (i[1] * 3) - (i[2]);
            Label KlassementEntry = new Label(ranking + ": " + dc.getSpelerNaamById(i[0]) + ", Score: " + score);
            setHalignment(KlassementEntry,HPos.CENTER);
            this.add(KlassementEntry, 0, ranking);
            ranking++;
        }
        
        /* Terug button */
        Button btnTerug = new Button(Taal.geefString("guiTerug"));
        setHalignment(btnTerug,HPos.CENTER);
        this.add(btnTerug, 0, 0);
        
        /* Terug button actie */
        btnTerug.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                hs.toonMenu();
            }
        });
    }
}