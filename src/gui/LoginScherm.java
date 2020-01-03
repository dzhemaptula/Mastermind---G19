package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import domein.DomeinController;
import taal.Taal;

//  indien verkeerde login
//  public void wrongInputFXML() throws IOException 
//        {
//        Parent root = FXMLLoader.load(getClass().getResource(
//                "WrongUsernameFXML.fxml"));
//        Stage errorStage = new Stage();
//        errorStage.setScene(new Scene(root));
//        errorStage.setTitle("Error");
//        errorStage.centerOnScreen();
//        errorStage.show();
//        }
public class LoginScherm extends GridPane
{
    public LoginScherm(DomeinController dc, HoofdScherm hs)
    {
        this.setAlignment(Pos.CENTER);
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(25, 25, 25, 25));

        //login titel
        Label lblTitle = new Label(Taal.geefString("guiLogin"));
        this.add(lblTitle, 0, 0, 2, 1);

        //gerbuikersnaam tekst
        Label lblGebruikersnaam = new Label(Taal.geefString("getGebruikerTekst"));
        this.add(lblGebruikersnaam, 0, 1);

        //gerbuikersnaam tekstveld
        TextField txfGebruiker = new TextField();
        this.add(txfGebruiker, 1, 1);
        txfGebruiker.setId("textField");

        //gerbuikersnaam tekst
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

        //login button
        Button btnLogIn = new Button(Taal.geefString("guiLogin"));
        setHalignment(btnLogIn, HPos.LEFT);
        this.add(btnLogIn, 0, 4);

        Label errorCode = new Label();
        this.add(errorCode, 5, 0);

        btnLogIn.setOnAction(new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event)
            {

                boolean aangemeld = false;
                try
                {
                    if (dc.meldAan(txfGebruiker.getText(), pwfWachtwoord.getText()) == null)
                    {
                        throw new IllegalArgumentException();
                    }
                    aangemeld = true;
                } catch (IllegalArgumentException e)
                {
                    errorCode.setText(Taal.geefString("getNietCorrecteLogin"));
                }
                if (aangemeld)
                {
                    hs.setDc(dc);
                    hs.toonMenu();
                }
            }
        });

        //sign up button
        Button btnSignUp = new Button(Taal.geefString("guiSignUp"));
        setHalignment(btnSignUp, HPos.LEFT);
        this.add(btnSignUp, 1, 4);

        btnSignUp.setOnAction(new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event)
            {
                hs.toonRegistreerScherm();
            }
        });
    }
}
