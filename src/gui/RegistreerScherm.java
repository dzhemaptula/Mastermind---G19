package gui;

import java.nio.file.Paths;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import domein.DomeinController;
import java.util.Locale;
import java.util.ResourceBundle;
import taal.Taal;

public class RegistreerScherm extends GridPane
{
    public RegistreerScherm(DomeinController dc, HoofdScherm hs)
    {
        this.setAlignment(Pos.CENTER);
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(25, 25, 25, 25));

        //login titel
        Label lblTitle = new Label(Taal.geefString("guiSignUp"));
        this.add(lblTitle, 0, 0, 2, 1);

        //gerbuikersnaam tekst
        Label lblGebruikersnaam = new Label(Taal.geefString("getGebruikerTekst"));
        this.add(lblGebruikersnaam, 0, 1);

        //gerbuikersnaam tekstveld
        TextField txfGebruiker = new TextField();
        this.add(txfGebruiker, 1, 1);
        txfGebruiker.setId("textField");

        //wachtwoord tekst
        Label lblWachtwoord = new Label(Taal.geefString("getWachtwoordTekst"));
        this.add(lblWachtwoord, 0, 2);

        //wachtwoord tekstveld
        PasswordField pwfWachtwoord = new PasswordField();
        this.add(pwfWachtwoord, 1, 2);
        pwfWachtwoord.setId("textField");

        //info wachtwoord
        Tooltip tooltip = new Tooltip();
        tooltip.setText("\n" + Taal.geefString("getWachtwoordVoorwaarden") + "\n");
        pwfWachtwoord.setTooltip(tooltip);

        //wachtwoord tekst
        Label lblbevestigWachtwoord = new Label(Taal.geefString("getBevestigingsWachtwoord"));
        this.add(lblbevestigWachtwoord, 0, 4);

        //wachtwoord tekstveld
        PasswordField pwfbevestigWachtwoord = new PasswordField();
        this.add(pwfbevestigWachtwoord, 1, 4);
        pwfbevestigWachtwoord.setId("textField");

        //info wachtwoord
        Tooltip bevestigtooltip = new Tooltip();
        bevestigtooltip.setText("\n" + Taal.geefString("getWachtwoordVoorwaarden") + "\n");
        pwfWachtwoord.setTooltip(bevestigtooltip);

        //login button
        Button btnSignUp = new Button(Taal.geefString("guiSignUp"));
        setHalignment(btnSignUp, HPos.LEFT);
        this.add(btnSignUp, 0, 6);
        Label errorCode = new Label();
        this.add(errorCode, 5, 0);

        btnSignUp.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                boolean ingelogd = false;
                try
                {
                    dc.registreer(txfGebruiker.getText(), pwfWachtwoord.getText(), pwfbevestigWachtwoord.getText());
                    ingelogd = true;
                } catch (IllegalArgumentException e)
                {
                    if (e.getMessage().equals("wwOngelijk"))
                    {
                        errorCode.setText(Taal.geefString("getWachtwoordenMoetenGelijkZijn"));
                    } else if (e.getMessage().equals("wwVoorwaarden"))
                    {
                        errorCode.setText(Taal.geefString("getWachtwoordenMoetenVoldoenAanVoorwaarden"));
                    } else if (e.getMessage().equals("naamBestaat"))
                    {
                        errorCode.setText(Taal.geefString("getNaamBestaat"));
                    } else if (e.getMessage().equals("naamLeeg"))
                    {
                        errorCode.setText(Taal.geefString("getNaamLeeg"));
                    }
                }
                if (ingelogd)
                {
                    hs.toonMenu();
                }
            }
        });
    }
}
