package com.example.proyectofinal.model;

public class Planeta {
    //URL_NASA + strUrl+"/"+strUrl+"~orig.jpg"
    private String url;
    private String nasa_id;
    private String titulo;

    public Planeta(String nasa_id, String titulo) {
        this.url = "https://images-assets.nasa.gov/image/"+nasa_id+"/"+nasa_id+"~thumb.jpg";
        this.nasa_id = nasa_id;
        this.titulo = titulo;

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
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
