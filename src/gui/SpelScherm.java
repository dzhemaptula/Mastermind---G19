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


public class SpelScherm extends GridPane
{
   
    public SpelScherm(DomeinController dc)
    {
        this.setAlignment(Pos.CENTER);
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(25, 25, 25, 25));
        
        //sign up button
        Button btnSpel1 = new Button("Spel1");
        setHalignment(btnSpel1, HPos.LEFT);
        this.add(btnSpel1,1, 4);
        Label welkom = new Label(Taal.geefString("getWelkom")+", "+dc.getSpelersNaam());
        this.add(welkom, 0, 0);
        
        btnSpel1.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {

                SpelbordScherm grid = new SpelbordScherm();
                Scene spelbordScherm = new Scene(grid, 700, 400);
                Stage newWindow = new Stage();
                String uri = Paths.get("src/gui/Viper.css").toUri().toString();
                spelbordScherm.getStylesheets().add(uri);
                newWindow.setTitle("Sign Up");
                newWindow.setScene(spelbordScherm);
                newWindow.show();
            }
        });   
    }
}