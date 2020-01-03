/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javafx.scene.layout.GridPane;
import domein.DomeinController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import static javafx.scene.layout.GridPane.setHalignment;
import taal.Taal;

/**
 *
 * @author dzhem
 */
public class MoeilijkheidScherm extends GridPane
{

    public MoeilijkheidScherm(DomeinController dc, HoofdScherm hs)
    {
        this.setAlignment(Pos.CENTER);
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(25, 25, 25, 25));

        Button btnMakkelijk = new Button(Taal.geefString("guiEasy"));
        setHalignment(btnMakkelijk, HPos.LEFT);
        this.add(btnMakkelijk, 2, 0);
        Button btnNormaal = new Button(Taal.geefString("guiNormal"));
        setHalignment(btnNormaal, HPos.LEFT);
        this.add(btnNormaal, 2, 2);
        Button btnMoeilijk = new Button(Taal.geefString("guiHard"));
        setHalignment(btnMoeilijk, HPos.LEFT);
        this.add(btnMoeilijk, 2, 4);

        btnMakkelijk.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                dc.startSpel(1);
                hs.setDc(dc);
                hs.toonVierSpelbord();
            }
        });
        btnNormaal.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                dc.startSpel(2);
                hs.setDc(dc);
                hs.toonVierSpelbord();
            }
        });
        btnMoeilijk.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                dc.startSpel(3);
                hs.setDc(dc);
                hs.toonVijfSpelbord();
            }
        });

    }
}
