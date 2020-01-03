/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taal;

import java.util.ResourceBundle;

/**
 *
 * @author dzhem
 */
public class Taal
{
    private static ResourceBundle bundle;
    private final int taal;//1=nl,2=en,3=fr
    public Taal(int taal){
        this.taal = taal;
    }
    public static String geefString(String teVertalen){
       return bundle.getString(teVertalen);
    }
    public static void setBundle(ResourceBundle bundle){
        Taal.bundle = bundle;
    }
    public static ResourceBundle getBundle(){
        return bundle;
    }
}
