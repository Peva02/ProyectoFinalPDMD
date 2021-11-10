package com.example.proyectofinal.controller;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
        //Añadir boton en actionBar para volver al Home activity
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}

