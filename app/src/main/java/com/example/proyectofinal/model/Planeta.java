package com.example.proyectofinal.model;

public class Planeta {
    //La URL se forma a partir del nasa_id obtenido al leer el json"
    private String url;
    private String nasa_id;
    private String titulo;

    public Planeta(String nasa_id, String titulo) {
        this.url = "https://images-assets.nasa.gov/image/" + nasa_id + "/" + nasa_id + "~thumb.jpg";
        this.nasa_id = nasa_id;
        this.titulo = titulo;

    }

    public String getUrl() {
        return url;
    }

    public String getNasa_id() {
        return nasa_id;
    }

    public String getTitulo() {
        return titulo;
    }
}
