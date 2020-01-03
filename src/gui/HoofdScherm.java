/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domein.DomeinController;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.scene.layout.BorderPane;
import taal.Taal;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import java.net.URL;

/**
 * @author Dzhem Aptula, Nick De Loor, Merijn Maene, Bert Schouteere
 */
public class HoofdScherm extends BorderPane
{

    private DomeinController dc;
    private int taal = 0;

    public HoofdScherm(DomeinController dc)
    {
        setDc(dc);
        this.setCenter(new KiesTaal(dc, this));
    }

    public void toonLoginScherm()
    {
        this.setCenter(new LoginScherm(dc, this));
    }

    public void setDc(DomeinController dc)
    {
        this.dc = dc;
    }

    public void stelTaalIn(Locale locale)
    {
        Taal.setBundle(ResourceBundle.getBundle("taal/LabelsBundle", locale));
    }

    public void toonMenu()
    {
        this.setCenter(new Menu(dc, this));
    }

    public void toonVierSpelbord()
    {
        this.setCenter(new SpelbordVisueelVier(dc, this));
    }

    public void toonVijfSpelbord()
    {
        this.setCenter(new SpelbordVisueelVijf(dc, this));
    }

    public void toonMoeilijkheidscherm()
    {
        this.setCenter(new MoeilijkheidScherm(dc, this));
    }

    public void toonRegistreerScherm()
    {
        this.setCenter(new RegistreerScherm(dc, this));
    }

    public void toonKlassementScherm()
    {
        this.setCenter(new KlassementScherm(dc, this));
    }

    public void toonLaadOpScherm()
    {
        this.setCenter(new LaadSpelOp(dc, this));
    }

    public void toonDaagUitScherm()
    {
        this.setCenter(new DaagUit(dc, this));
    }

    public void toonBekijkUitdagingen()
    {
        this.setCenter(new BekijkUitdagingen(dc, this));
    }
}
