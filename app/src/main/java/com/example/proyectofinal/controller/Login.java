package com.example.proyectofinal.controller;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
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
    /**
     * Dependiendo el boton que se pulse, mostrará una interfaz diferente, dependiendo si el usuario
     * desea iniciar sesion o registrarse como un usuario nuevo.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        /**Visible muestra el objeto y GONE oculta el objeto*/
        findViewById(R.id.login).setVisibility(View.VISIBLE);
        findViewById(R.id.add).setVisibility(View.VISIBLE);
        findViewById(R.id.register).setVisibility(View.GONE);
        findViewById(R.id.cancel).setVisibility(View.GONE);


        TextView add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findViewById(R.id.login).setVisibility(View.GONE);
                findViewById(R.id.add).setVisibility(View.GONE);
                findViewById(R.id.register).setVisibility(View.VISIBLE);
                findViewById(R.id.cancel).setVisibility(View.VISIBLE);

            }
        });

        /**Comprueba que los campos esten rellenos, si estan rellenos registra el usuario, si no,
         * muestra un alertDialog, indicando que debe rellenar los campos
         */
        Button register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText user = (EditText) findViewById(R.id.user);
                EditText passwd = (EditText) findViewById(R.id.passwd);
                if (user.getText().toString().trim().isEmpty() || passwd.getText().toString().trim().isEmpty()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                    builder.setTitle("Error");
                    builder.setMessage("Compruebe que los campos estan rellenos");
                    builder.setPositiveButton("Aceptar", null);

                    AlertDialog dialog = builder.create();
                    dialog.show();
                } else {
                    Toast.makeText(getApplicationContext(), "Usuario registrado", Toast.LENGTH_SHORT).show();
                    user.setText(null);
                    passwd.setText(null);
                    findViewById(R.id.login).setVisibility(View.VISIBLE);
                    findViewById(R.id.add).setVisibility(View.VISIBLE);
                    findViewById(R.id.register).setVisibility(View.GONE);
                    findViewById(R.id.cancel).setVisibility(View.GONE);
                }

            }
        });

        /**Si el login es correcto, muestra el reciclerView de los coches*/
        Button login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this, RecView.class);
                startActivity(i);
            }
        });
        /**Si cancela el registro, vuelve a la pagina de registrar*/
        TextView cancel = findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this, Login.class);
                startActivity(i);
            }
        });

    }
}