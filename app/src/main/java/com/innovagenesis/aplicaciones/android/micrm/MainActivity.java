package com.innovagenesis.aplicaciones.android.micrm;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import com.innovagenesis.aplicaciones.android.mylibrary.CadenasTexto;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**Seccion del Toolbar*/
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        /**Seccion del Boton Flotante*/
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        /**Seccion del Drawer*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        /******************************************************************************************/

        /**Seccion del TextView*/
        TextView textView = (TextView) findViewById(R.id.main); //Enlace textView Content_main

        /**Invoca metodo que cambia los textos*/

        String textos = CadenasTexto.bienvenida; //Libreria
        /**
         * Se implementa getSupportAction debido a que si el metodo no es statico genera error
         *
         *      Revisar despúes Rev. v160907 - ARH
         *
         *            toolbar = (Toolbar) findViewById(R.id.toolbar);
         *            setSupportActionBar(toolbar);
         *            getSupportActionBar().setTitle(textos);
         *
         * */

        ActionBar actionBar = getSupportActionBar();
        Miscelaneos.changedText(textos, textView, actionBar); //Metodo encargado de cambiar string

        /******************************************************************************************/

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        /** Administra los botones del Drawer*/
        int id = item.getItemId();

        Intent intent;

        if (id == R.id.home) {

            intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        } else if (id == R.id.materialDesign) {

            intent = new Intent(this, MaterialDesign.class);
            startActivity(intent);

        } else if (id == R.id.conceptosAvanzados) {

            intent = new Intent(this, ConceptosAvanzados.class);
            startActivity(intent);

        } else if (id == R.id.desarrolloApp) {

            intent = new Intent(this, DesarrolloApp.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
