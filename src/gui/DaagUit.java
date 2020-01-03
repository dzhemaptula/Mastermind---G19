package gui;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import domein.DomeinController;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import taal.Taal;

public class DaagUit extends Pane
{

    protected final Button btnBack;
    protected final TextArea txaSpelers;
    protected final Button btnChoose;
    protected final TextField txfSpelerid;

    public DaagUit(DomeinController dc, HoofdScherm hs)
    {

        dc.startSpel();
        btnBack = new Button();
        txaSpelers = new TextArea();
        btnChoose = new Button();
        txfSpelerid = new TextField();

        setPrefHeight(474.0);
        setPrefWidth(675.0);

        btnBack.setLayoutX(505.0);
        btnBack.setLayoutY(401.0);
        btnBack.setMnemonicParsing(false);
        btnBack.setPrefHeight(39.0);
        btnBack.setPrefWidth(106.0);
        btnBack.setText(Taal.geefString("guiTerug"));

        txaSpelers.setLayoutX(65.0);
        txaSpelers.setLayoutY(41.0);
        txaSpelers.setPrefHeight(338.0);
        txaSpelers.setPrefWidth(546.0);

        btnChoose.setLayoutX(178.0);
        btnChoose.setLayoutY(401.0);
        btnChoose.setMnemonicParsing(false);
        btnChoose.setPrefHeight(39.0);
        btnChoose.setPrefWidth(106.0);
        btnChoose.setText(Taal.geefString("guiChoose"));

        txfSpelerid.setLayoutX(65.0);
        txfSpelerid.setLayoutY(401.0);
        txfSpelerid.setPrefHeight(39.0);
        txfSpelerid.setPrefWidth(98.0);

        getChildren().add(btnBack);
        getChildren().add(txaSpelers);
        getChildren().add(btnChoose);
        getChildren().add(txfSpelerid);
        for (String i : dc.geefSpelers(dc.getSpelersNaam()))
        {
            txaSpelers.appendText(i+"\n");
        }
        btnBack.setOnAction(new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event)
            {
                hs.toonMenu();
            }
        });
        btnChoose.setOnAction(new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event)
            {
                boolean geldigeSpeler = false;

                try
                {
                    if(dc.bestaatSpelerById(Integer.parseInt(txfSpelerid.getText()))){
                        geldigeSpeler = true;
                    }else{
                        throw new Exception();
                    }
                    
                } catch (Exception exc)
                {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText(Taal.geefString("getOngeldigeKeuze"));
                    alert.showAndWait().ifPresent(rs ->
                    {
                        if (rs == ButtonType.OK)
                        {
                            System.out.println("OK");
                        }
                    });
                }

                if (geldigeSpeler)
                {
                    dc.setUitgedaagdeSpeler(dc.getSpelerNaamById(Integer.parseInt(txfSpelerid.getText())));
                    hs.setDc(dc);
                    if (dc.getMoeilijkheidsgraad() == 3)
                    {
                        hs.toonMoeilijkheidscherm();
                    } else
                    {
                        hs.toonMoeilijkheidscherm();
                    }
                }
            }
        });
    }

}
