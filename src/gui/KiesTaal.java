package gui;

import domein.DomeinController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.util.Locale;

import static javafx.scene.layout.GridPane.setHalignment;

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

public class KiesTaal extends GridPane
{
    Button btnNederlands, btnFrans, btnEngels;
    private static final Locale[] LOCALES =
    {
        new Locale("nl"), new Locale("en"), new Locale("fr")
    };

    public KiesTaal(DomeinController dc, HoofdScherm hs)
    {
        this.setAlignment(Pos.CENTER);
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(25, 25, 25, 25));

        btnNederlands = new Button("Nederlands");
        setHalignment(btnNederlands, HPos.LEFT);
        this.add(btnNederlands, 2, 0);
        btnFrans = new Button("Français");
        setHalignment(btnFrans, HPos.LEFT);
        this.add(btnFrans, 2, 2);
        //login button
        btnEngels = new Button("English");
        setHalignment(btnEngels, HPos.LEFT);
        this.add(btnEngels, 2, 4);

        btnFrans.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                hs.stelTaalIn(LOCALES[2]);
                hs.toonLoginScherm();

            }
        });
        btnNederlands.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                hs.stelTaalIn(LOCALES[0]);
                hs.toonLoginScherm();
            }
        });
        btnEngels.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                hs.stelTaalIn(LOCALES[1]);
                hs.toonLoginScherm();
            }
        });

    }
}