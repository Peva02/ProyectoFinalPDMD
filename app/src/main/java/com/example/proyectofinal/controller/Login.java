package com.example.proyectofinal.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectofinal.R;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewById(R.id.login).setVisibility(View.VISIBLE);
        findViewById(R.id.add).setVisibility(View.VISIBLE);
        findViewById(R.id.register).setVisibility(View.GONE);


        TextView add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findViewById(R.id.login).setVisibility(View.GONE);
                findViewById(R.id.add).setVisibility(View.GONE);
                findViewById(R.id.register).setVisibility(View.VISIBLE);
            }
        });

        Button register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Usuario registrado", Toast.LENGTH_SHORT).show();
                EditText user = (EditText) findViewById(R.id.user);
                user.setText(null);
                EditText passwd = (EditText) findViewById(R.id.passwd);
                passwd.setText(null);
                findViewById(R.id.login).setVisibility(View.VISIBLE);
                findViewById(R.id.add).setVisibility(View.VISIBLE);
                findViewById(R.id.register).setVisibility(View.GONE);
            }
        });

        Button login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this, RecView.class);
                startActivity(i);
            }
        });

    }
}