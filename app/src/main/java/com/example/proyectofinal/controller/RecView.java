package com.example.proyectofinal.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectofinal.R;
import com.example.proyectofinal.adapter.Adapter;
import com.example.proyectofinal.model.Coches;

import java.util.ArrayList;
import java.util.List;

public class RecView extends AppCompatActivity {
    ArrayList<Coches> listCoches;
    RecyclerView recyclerView;
    //Instancio adaptador de mi clase
    Adapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listCoches = new ArrayList<>();
        recyclerAdapter = new Adapter(setCoches());
        //Creo un setOnclickListener que al pulsarlo, lanzará una nueva actividad donde se mostrará,la imagen del coche, con su nombre
        //y descipcion
        recyclerAdapter.setOnclickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RecView.this, DescCoche.class);
                String nombre = listCoches.get(recyclerView.getChildAdapterPosition(view)).getNombre();
                String desc = listCoches.get(recyclerView.getChildAdapterPosition(view)).getDesc();
                int image = listCoches.get(recyclerView.getChildAdapterPosition(view)).getImagen();

                i.putExtra("nombre", nombre);
                i.putExtra("desc", desc);
                i.putExtra("imagen", image);

                startActivity(i);
            }
        });
        //Creo un GridLayoutManager de tal manera que se muestren dos objetos por fila
        GridLayoutManager glayout = new GridLayoutManager(this, 2);
        recyclerView = findViewById(R.id.recView);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(glayout);
    }

    //Llena el array de objetos
    private List<Coches> setCoches() {
        listCoches = new ArrayList<Coches>(listCoches);
        listCoches.add(new Coches(R.drawable.audi, "Audi R8", "Es un coche que es muy rapido y bonito"));
        listCoches.add(new Coches(R.drawable.audi, "Audi R8", "Es un coche que es muy rapido y bonito"));
        listCoches.add(new Coches(R.drawable.cooper, "Cooper", "Es un coche pequeño y con mucha movilidad"));
        listCoches.add(new Coches(R.drawable.audi, "Audi R8", "Es un coche que es muy rapido y bonito"));
        listCoches.add(new Coches(R.drawable.cooper, "Cooper", "Es un coche pequeño y con mucha movilidad"));
        listCoches.add(new Coches(R.drawable.audi, "Audi R8", "Es un coche que es muy rapido y bonito"));
        listCoches.add(new Coches(R.drawable.cooper, "Cooper", "Es un coche pequeño y con mucha movilidad"));
        listCoches.add(new Coches(R.drawable.cooper, "Cooper", "Es un coche pequeño y con mucha movilidad"));
        listCoches.add(new Coches(R.drawable.audi, "Audi R8", "Es un coche que es muy rapido y bonito"));
        listCoches.add(new Coches(R.drawable.cooper, "Cooper", "Es un coche pequeño y con mucha movilidad"));
        listCoches.add(new Coches(R.drawable.audi, "Audi R8", "Es un coche que es muy rapido y bonito"));
        listCoches.add(new Coches(R.drawable.cooper, "Cooper", "Es un coche pequeño y con mucha movilidad"));
        listCoches.add(new Coches(R.drawable.cooper, "Cooper", "Es un coche pequeño y con mucha movilidad"));
        listCoches.add(new Coches(R.drawable.audi, "Audi R8", "Es un coche que es muy rapido y bonito"));
        listCoches.add(new Coches(R.drawable.cooper, "Cooper", "Es un coche pequeño y con mucha movilidad"));
        listCoches.add(new Coches(R.drawable.audi, "Audi R8", "Es un coche que es muy rapido y bonito"));
        listCoches.add(new Coches(R.drawable.cooper, "Cooper", "Es un coche pequeño y con mucha movilidad"));
        listCoches.add(new Coches(R.drawable.cooper, "Cooper", "Es un coche pequeño y con mucha movilidad"));


        return listCoches;
    }
}