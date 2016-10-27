package com.innovagenesis.aplicaciones.android.micrm;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.innovagenesis.aplicaciones.android.mylibrary.CadenasTexto;

public class MaterialDesign extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_design);

        /**Se administran los textos de la clase*/

        String conceptosAvan = CadenasTexto.materialDesign;
        TextView textView = (TextView)findViewById(R.id.materialDesign);
        ActionBar actionBar = getSupportActionBar();

        Miscelaneos.changedText(conceptosAvan,textView,actionBar); //Encargado de contruir textos

        Button button = (Button)findViewById(R.id.btn_material_design);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /** Devuelve al main*/
                Intent intent = new Intent(MaterialDesign.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
