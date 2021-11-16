package com.example.proyectofinal.controller;

import static com.example.proyectofinal.R.id.ajustes;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectofinal.R;

public class DescCoche extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desc_coche);
        /**Añadir boton en actionBar para volver al Home activity*/
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        TextView txtNombre = findViewById(R.id.txtNombre);
        TextView txtDesc = findViewById(R.id.textDesc);
        ImageView imgCoche = findViewById(R.id.imgCoche);

        Intent i = getIntent();

        String nombre = i.getStringExtra("nombre");
        txtNombre.setText(nombre);

        String desc = i.getStringExtra("desc");
        txtDesc.setText(desc);

        int image = i.getIntExtra("imagen", -1);
        if (image == -1) {
            Toast.makeText(getApplicationContext(), "Error al cargar las imagenes", Toast.LENGTH_SHORT).show();
        } else {
            imgCoche.setImageResource(image);
        }
    }

    /**
     * Añade el boton de ajustes a ActionBar
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_preferences, menu);
        return true;
    }

    /**
     * Indica que va a sudecer cuando se pulse cada botón
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.ajustes:
                Intent i = new Intent(DescCoche.this, Preferences.class);
                startActivity(i);
                return true;
        }
        return false;
    }

}

