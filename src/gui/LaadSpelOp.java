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

public class LaadSpelOp extends Pane
{

    protected final Button btnBack;
    protected final TextArea txaSpelletjes;
    protected final Button btnChoose;
    protected final TextField txfSpelid;

    public LaadSpelOp(DomeinController dc, HoofdScherm hs)
    {
        
        dc.startSpel();
        btnBack = new Button();
        txaSpelletjes = new TextArea();
        btnChoose = new Button();
        txfSpelid = new TextField();

        setPrefHeight(474.0);
        setPrefWidth(675.0);

        btnBack.setLayoutX(505.0);
        btnBack.setLayoutY(401.0);
        btnBack.setMnemonicParsing(false);
        btnBack.setPrefHeight(39.0);
        btnBack.setPrefWidth(106.0);
        btnBack.setText(Taal.geefString("guiTerug"));

        txaSpelletjes.setLayoutX(65.0);
        txaSpelletjes.setLayoutY(41.0);
        txaSpelletjes.setPrefHeight(338.0);
        txaSpelletjes.setPrefWidth(546.0);

        btnChoose.setLayoutX(178.0);
        btnChoose.setLayoutY(401.0);
        btnChoose.setMnemonicParsing(false);
        btnChoose.setPrefHeight(39.0);
        btnChoose.setPrefWidth(106.0);
        btnChoose.setText(Taal.geefString("guiChoose"));

        txfSpelid.setLayoutX(65.0);
        txfSpelid.setLayoutY(401.0);
        txfSpelid.setPrefHeight(39.0);
        txfSpelid.setPrefWidth(98.0);

        getChildren().add(btnBack);
        getChildren().add(txaSpelletjes);
        getChildren().add(btnChoose);
        getChildren().add(txfSpelid);

        List<String> bewaardeSpellen = dc.getBewaardeSpellen();
        for (String i : bewaardeSpellen)
        {
            txaSpelletjes.appendText(i + "\n");
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
                boolean spelOpgeladen = false;

                try
                {
                    dc.laadSpelOp(Integer.parseInt(txfSpelid.getText()));
                    dc.verwijderSpel(Integer.parseInt(txfSpelid.getText()));
                    spelOpgeladen = true;
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

                if (spelOpgeladen)
                {
                    hs.setDc(dc);
                    if (dc.getMoeilijkheidsgraad() == 3)
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
