package com.example.proyectofinal.io;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiConect {
    private static String URL_NASA = "https://images-api.nasa.gov/search?q=\"\"";

    public static String getRequest() {
        HttpURLConnection http = null;
        String content = null;
        try {
            URL url = new URL(URL_NASA);
            http = (HttpURLConnection) url.openConnection();
            http.setRequestProperty("Content-Type", "application/json");
            http.setRequestProperty("Accept", "application/json");
            if (http.getResponseCode() == HttpURLConnection.HTTP_OK) {
                Log.d("Codigo","Codigo Correcto");
                StringBuilder sb = new StringBuilder();
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(http.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
                content = sb.toString();
                reader.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (http != null) http.disconnect();
        }
        return content;
    }
}
