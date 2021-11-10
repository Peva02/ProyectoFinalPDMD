package com.example.proyectofinal.model;

public class Coches {
    private int imagen;
    private String nombre;

    public Coches(int imagen, String nombre) {
        this.imagen = imagen;
        this.nombre = nombre;

    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
