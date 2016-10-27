package com.innovagenesis.aplicaciones.android.micrm;


import android.support.v7.app.ActionBar;
import android.util.Log;
import android.widget.TextView;

public class Miscelaneos{

    public Miscelaneos(){
     /*Contructor*/
    }

    public static void changedText(String textos, TextView textView, ActionBar actionBar){

        /**Cambia los textos principales*/

        textView.setText(textos);
        assert actionBar != null;
        actionBar.setTitle(textos);
        Log.i("Textos:",textos);

    }
}
