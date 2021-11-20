package com.example.proyectofinal.controller;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectofinal.R;
import com.example.proyectofinal.adapter.Adapter;
import com.example.proyectofinal.io.ApiConect;
import com.example.proyectofinal.model.Planeta;
import com.orhanobut.logger.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RecView extends AppCompatActivity {
    ArrayList<Planeta> listPlanetas;
    RecyclerView recyclerView;
    //Instancio adaptador de mi clase
    Adapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rec_view);

        new URL().execute();

        listPlanetas = new ArrayList<>();
        recyclerAdapter = new Adapter(setPlanetas());
        /**Creo un setOnclickListener que al pulsarlo, lanzará una nueva actividad donde se mostrará,la imagen del coche, con su nombre
         y descipcion*/
        recyclerAdapter.setOnclickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RecView.this, DescPlaneta.class);
                String url = listPlanetas.get(recyclerView.getChildAdapterPosition(view)).getUrl();
                String nasa_id = listPlanetas.get(recyclerView.getChildAdapterPosition(view)).getNasa_id();
                String titulo = listPlanetas.get(recyclerView.getChildAdapterPosition(view)).getTitulo();

                i.putExtra("nombre", nasa_id);
                i.putExtra("desc", titulo);
                i.putExtra("imagen", url);

                startActivity(i);
            }
        });
        /**Creo un GridLayoutManager de tal manera que se muestren dos objetos por fila*/
        GridLayoutManager glayout = new GridLayoutManager(this, 2);
        recyclerView = findViewById(R.id.recView);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(glayout);
    }

    /**
     * Llena el array de objetos
     */
    private List<Planeta> setPlanetas() {
        listPlanetas = new ArrayList<Planeta>(listPlanetas);

        return listPlanetas;
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


    public class URL extends AsyncTask<String, Void, String> {
        private ArrayList<String> planetas;

        @Override
        protected String doInBackground(String... strings) {
            String result, nasa_id = "\"\"";
            result = ApiConect.getRequest(nasa_id);
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            try {
                /**Con la biblioteca PRETTY_LOGGER formatea da formato al JSON del log*/
                Logger.t("Planetas").json(s);

                if (s != null) {
                    JSONObject jsonObject = new JSONObject(s);
                    JSONArray jsonArray = jsonObject.getJSONArray("results");
                    /**Aqui da fallo al leer objetos del json*/
                    String items = "";
                    for (int i = 0; i < 10; i++) {
                        items = jsonArray.getJSONObject(i).getString("items");
                        planetas.add(items);
                    }

                } else {
                    Toast.makeText(getApplicationContext(), "Problema al cargar los datos", Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                Logger.t("json_error").e("Error al leer JSON");
                e.printStackTrace();
            }
        }
    }
}