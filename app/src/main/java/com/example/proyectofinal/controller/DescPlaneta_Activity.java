package com.example.proyectofinal.controller;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.proyectofinal.R;

public class DescPlaneta_Activity extends AppCompatActivity {
    private CircularProgressDrawable progressDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desc_planeta);
        /**Añadir boton en actionBar para volver al Home activity*/
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        TextView txtTitle = findViewById(R.id.txtTitle);
        TextView texNasa_id = findViewById(R.id.texNasa_id);
        ImageView urlImagen = findViewById(R.id.imgPlaneta);

        /**Busco la url de la imagen en concreto*/

        Intent i = getIntent();

        String title = i.getStringExtra("title");
        txtTitle.setText(title.toUpperCase());

        String nasa_id = i.getStringExtra("nasa_id");
        texNasa_id.setText(nasa_id);

        if (urlImagen == null) {
            Toast.makeText(getApplicationContext(), "Error al cargar las imagenes", Toast.LENGTH_SHORT).show();
        } else {
            progressDrawable = new CircularProgressDrawable(this);
            progressDrawable.setStrokeWidth(15f);
            progressDrawable.setStyle(CircularProgressDrawable.LARGE);
            progressDrawable.setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
            progressDrawable.setCenterRadius(35f);
            progressDrawable.start();
            Glide.with(this)
                    .load(i.getStringExtra("url_imagen"))
                    .placeholder(progressDrawable)
                    .into(urlImagen);
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
                Intent i = new Intent(DescPlaneta_Activity.this, Preferences_Activity.class);
                startActivity(i);
                return true;
        }
        return false;
    }
}


