package com.example.proyectofinal.controller.login;

import com.orm.SugarRecord;

public class BD extends SugarRecord {
    /**
     * Campos de la tabla
     */
    private String user;
    private String passwd;

    /**
     * Construstores
     */
    public BD() {

    }

    public BD(String user, String passwd) {
        this.user = user;
        this.passwd = passwd;
    }

    /**
     * Get and Set
     */
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

}
