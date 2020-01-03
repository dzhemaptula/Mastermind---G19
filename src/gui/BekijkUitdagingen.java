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

public class BekijkUitdagingen extends Pane
{

    protected final Button btnBack;
    protected final TextArea txaUitdagingen;
    protected final Button btnChoose;
    protected final TextField txfUitdagingid;

    public BekijkUitdagingen(DomeinController dc, HoofdScherm hs)
    {

        dc.startSpel();
        btnBack = new Button();
        txaUitdagingen = new TextArea();
        btnChoose = new Button();
        txfUitdagingid = new TextField();

        setPrefHeight(474.0);
        setPrefWidth(675.0);

        btnBack.setLayoutX(505.0);
        btnBack.setLayoutY(401.0);
        btnBack.setMnemonicParsing(false);
        btnBack.setPrefHeight(39.0);
        btnBack.setPrefWidth(106.0);
        btnBack.setText(Taal.geefString("guiTerug"));

        txaUitdagingen.setLayoutX(65.0);
        txaUitdagingen.setLayoutY(41.0);
        txaUitdagingen.setPrefHeight(338.0);
        txaUitdagingen.setPrefWidth(546.0);

        btnChoose.setLayoutX(178.0);
        btnChoose.setLayoutY(401.0);
        btnChoose.setMnemonicParsing(false);
        btnChoose.setPrefHeight(39.0);
        btnChoose.setPrefWidth(106.0);
        btnChoose.setText(Taal.geefString("guiChoose"));

        txfUitdagingid.setLayoutX(65.0);
        txfUitdagingid.setLayoutY(401.0);
        txfUitdagingid.setPrefHeight(39.0);
        txfUitdagingid.setPrefWidth(98.0);

        getChildren().add(btnBack);
        getChildren().add(txaUitdagingen);
        getChildren().add(btnChoose);
        getChildren().add(txfUitdagingid);
        for (String i : dc.toonUitdagingen(dc.getSpelerId(dc.getSpelersNaam())))
        {
            txaUitdagingen.appendText(i + "\n");
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
                boolean geldigeUitdaging = false;
                int gekozenUitdaging = Integer.parseInt(txfUitdagingid.getText());
                try
                {
                    if (dc.bestaatUitdaging(gekozenUitdaging))
                    {
                        geldigeUitdaging = true;
                    } else
                    {
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

                if (geldigeUitdaging)
                {
                    int uitdagingMoeilijkheid = dc.getUitdagingMoeilijkheid(gekozenUitdaging);
                    dc.startSpel(uitdagingMoeilijkheid);
                    dc.setGekozenUitdaging(gekozenUitdaging);
                    dc.verhoogLosses(dc.getSpelerId(dc.getSpelersNaam()));
                    dc.verhoogWins(dc.getTegenStanderIdByUitdagingId(gekozenUitdaging));
                    dc.aanvaardUitdaging();
                    hs.setDc(dc);
                    if (uitdagingMoeilijkheid == 3)
                    {
                        hs.toonVijfSpelbord();
                    } else
                    {
                        hs.toonVierSpelbord();
                    }
                }
            }
        });
    }

}
