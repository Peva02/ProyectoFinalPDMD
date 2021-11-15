package com.example.proyectofinal.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.proyectofinal.R;
import com.example.proyectofinal.fragments.Fragment;

public class Preferences extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);
        getSupportFragmentManager().beginTransaction().replace(R.id.layoutPreferences, new Fragment()).commit();
    }
}