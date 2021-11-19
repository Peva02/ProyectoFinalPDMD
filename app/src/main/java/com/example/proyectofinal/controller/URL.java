package com.example.proyectofinal.controller;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.proyectofinal.io.ApiConect;
import com.example.proyectofinal.model.Planeta;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class URL extends AsyncTask<String, Void, String> {
    private ArrayList<String> planetas;

    @Override
    protected String doInBackground(String... strings) {
        String result;
        result = ApiConect.getRequest(strings[1]);
        return result;
    }
}
