package com.example.proyectofinal.controller;

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
        //Creo un setOnclickListener que me mostrará el nombre que se le a introducido al objeto que se pulsa
        recyclerAdapter.setOnclickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), listCoches.get(recyclerView.getChildAdapterPosition(view)).getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
        //Creo un GridLayoutManager de tal manera que se muestren dos objetos por fila
        GridLayoutManager glayout = new GridLayoutManager(this,2);
        recyclerView = findViewById(R.id.recView);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(glayout);
    }

    //Llena el array de objetos
    private List<Coches> setCoches(){
        listCoches = new ArrayList<Coches>(listCoches);
        listCoches.add(new Coches(R.drawable.audi, "Audi R8"));
        listCoches.add(new Coches(R.drawable.audi, "fgghjjfgjgjfgjfghj R8"));
        listCoches.add(new Coches(R.drawable.cooper, "Audi R8"));
        listCoches.add(new Coches(R.drawable.cooper, "Audfgjfgjfgjgfi R8"));
        listCoches.add(new Coches(R.drawable.audi, "Audi R8"));
        listCoches.add(new Coches(R.drawable.cooper, "Audi R8"));
        listCoches.add(new Coches(R.drawable.audi, "fgghjjfgjgjfgjfghj R8"));
        listCoches.add(new Coches(R.drawable.cooper, "Audi R8"));
        listCoches.add(new Coches(R.drawable.cooper, "Audfgjfgjfgjgfi R8"));
        listCoches.add(new Coches(R.drawable.audi, "Audi R8"));
        listCoches.add(new Coches(R.drawable.cooper, "Audi R8"));
        listCoches.add(new Coches(R.drawable.audi, "fgghjjfgjgjfgjfghj R8"));
        listCoches.add(new Coches(R.drawable.cooper, "Audi R8"));
        listCoches.add(new Coches(R.drawable.cooper, "Audfgjfgjfgjgfi R8"));
        listCoches.add(new Coches(R.drawable.audi, "Audi R8"));
        listCoches.add(new Coches(R.drawable.cooper, "Audi R8"));


        return listCoches;
    }
}