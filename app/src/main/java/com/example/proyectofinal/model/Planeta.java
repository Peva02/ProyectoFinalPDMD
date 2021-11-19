package com.example.proyectofinal.model;

public class Planeta {
    //URL_NASA + strUrl+"/"+strUrl+"~orig.jpg"
    private int url;
    private String nasa_id;
    private String titulo;

    public Planeta(int url, String nasa_id, String titulo) {
        this.url = url;
        this.nasa_id = nasa_id;
        this.titulo = titulo;

    }

    public int getUrl() {
        return url;
    }

    public void setUrl(int url) {
        this.url = url;
    }

    public String getNasa_id() {
        return nasa_id;
    }

    public void setNasa_id(String nasa_id) {
        this.nasa_id = nasa_id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
