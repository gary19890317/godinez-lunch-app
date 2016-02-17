package com.godinezlunchapp.clases;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void lanzarUbicacion(View v){
    	Intent i = new Intent(this, ListaLugares.class);
    	startActivity(i);
    }
    
    public void lanzarFavoritos(View v){
    	Intent i = new Intent(this, ListaLugares.class);
    	startActivity(i);
    }
    
    public void lanzarAcercaDe(View v){
    	Intent i = new Intent(this, AcercaDe.class);
    	startActivity(i);
    }
    
    public void lanzarSalir(View v){
    	finish();
    }
   
    
   
}
