package com.example.proyectofinal.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectofinal.R;
import com.example.proyectofinal.adapter.Adapter;
import com.example.proyectofinal.model.Planeta;

import java.util.ArrayList;
import java.util.List;

public class RecView extends AppCompatActivity {
    ArrayList<Planeta> listCoches;
    RecyclerView recyclerView;
    //Instancio adaptador de mi clase
    Adapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rec_view);

        new URL().execute("PIA01143");

        listCoches = new ArrayList<>();
        recyclerAdapter = new Adapter(setCoches());
        /**Creo un setOnclickListener que al pulsarlo, lanzará una nueva actividad donde se mostrará,la imagen del coche, con su nombre
        y descipcion*/
        recyclerAdapter.setOnclickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RecView.this, DescPlaneta.class);
                String nombre = listCoches.get(recyclerView.getChildAdapterPosition(view)).getNasa_id();
                String desc = listCoches.get(recyclerView.getChildAdapterPosition(view)).getTitulo();
                int image = listCoches.get(recyclerView.getChildAdapterPosition(view)).getUrl();

                i.putExtra("nombre", nombre);
                i.putExtra("desc", desc);
                i.putExtra("imagen", image);

                startActivity(i);
            }
        });
        /**Creo un GridLayoutManager de tal manera que se muestren dos objetos por fila*/
        GridLayoutManager glayout = new GridLayoutManager(this, 2);
        recyclerView = findViewById(R.id.recView);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(glayout);
    }

    /**Llena el array de objetos*/
    private List<Planeta> setCoches() {
        listCoches = new ArrayList<Planeta>(listCoches);
        listCoches.add(new Planeta(R.drawable.audi, "Audi R8", "Es un coche que es muy rapido y bonito"));
        return listCoches;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_preferences, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i = new Intent(RecView.this, Preferences.class);
        startActivity(i);
        return true;
    }
}