package com.example.proyectofinal.controller.login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectofinal.R;
import com.example.proyectofinal.controller.RecView;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.util.List;

public class Login extends AppCompatActivity {

    private BD bd_user;

    /**
     * Dependiendo el boton que se pulse, mostrará una interfaz diferente, dependiendo si el usuario
     * desea iniciar sesion o registrarse como un usuario nuevo.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Logger.addLogAdapter(new AndroidLogAdapter());

        SugarContext.init(this);
        bd_user = BD.findById(BD.class, 1);
        /**Primero muestra la ventana de login*/
        showLogin();

        /**EL boton add cambia la vista de login a la de registrar un usuario*/
        TextView add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRegister();
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
                    checkCampos();
                } else {
                    /**Añadir usuario*/
                    addUser();
                    /**Vacio los campos y vuelo a mostrar la interfaz de login*/
                    user.setText(null);
                    passwd.setText(null);
                    showLogin();
                }

            }
        });


        /**Si el login es correcto, muestra el reciclerView de los coches*/
        Button login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText user = (EditText) findViewById(R.id.user);
                EditText passwd = (EditText) findViewById(R.id.passwd);
                if (user.getText().toString().trim().isEmpty() || passwd.getText().toString().trim().isEmpty()) {
                    checkCampos();
                } else {
                    if (loginUser()) {
                        Intent i = new Intent(Login.this, RecView.class);
                        startActivity(i);
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                        builder.setTitle("Error");
                        builder.setMessage("El usuario no se encuentra registrado.\nPor favor, registrese primero.");
                        builder.setPositiveButton("Aceptar", null);
                        AlertDialog dialog = builder.create();
                        dialog.show();

                    }
                }
            }
        });

        /**Si cancela el registro, vuelve a la pagina de registrar*/
        TextView cancel = findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showLogin();
            }
        });

    }


    /**
     * Metodo para guardar usuarios en la base de datos. Comprueba que el usuario y la contraseña no existe, si existe muestra un mensaje de error.
     */
    private void addUser() {
        /**Creamos una relacion de variables con la interfaz*/
        EditText user = findViewById(R.id.user);
        EditText passwd = findViewById(R.id.passwd);

        /**Comrpobamos si el usuario exixte*/
        Logger.t("AddUser").i(user.getText().toString() + " " + passwd.getText().toString());
        List<BD> usuarios = BD.find(BD.class, "user=? and passwd=?", user.getText().toString(), passwd.getText().toString());

        try {
            for (BD usuario : usuarios) {
                if (usuario.getUser().equals(user) && usuario.getPasswd().equals(passwd)) {
                    throw new Exception();
                }
            }

            /**Añadimos el ususario y la contraseña al objeto de la base de datos*/
            bd_user = new BD();
            bd_user.setUser(user.getText().toString());
            bd_user.setPasswd(passwd.getText().toString());

            long save = bd_user.save();
            Logger.t("AddUser").i("Usuario " + save + " añadido");
            Toast.makeText(getApplicationContext(), "Usuario registrado", Toast.LENGTH_SHORT).show();
        } catch (Exception ex) {
            AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
            builder.setTitle("Error");
            builder.setMessage("El usuario ya se encuentra registrado");
            builder.setPositiveButton("Aceptar", null);
            AlertDialog dialog = builder.create();
            dialog.show();
            Logger.t("AddUser").e("El usuario se encuentra registrado");

        }
    }

    private boolean loginUser() {
        /**Creamos una relacion de variables con la interfaz*/
        EditText user = findViewById(R.id.user);
        EditText passwd = findViewById(R.id.passwd);

        /**Comrpobamos si el usuario exixte*/
        Logger.t("LoginUser").i(user.getText().toString() + " " + passwd.getText().toString());
        List<BD> usuarios = BD.find(BD.class, "user=? and passwd=?", user.getText().toString(), passwd.getText().toString());
        int userExist = 0;
        try {
            for (BD usuario : usuarios) {
                if (usuario.getUser().equals(user.getText().toString()) && usuario.getPasswd().equals(passwd.getText().toString())) {
                    userExist = 1;
                }
            }
            if (userExist == 1) {
                Logger.t("LoginUser").i("Usuario logeado");
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception ex) {
            Logger.t("LoginUser").e("El usuario no se encuentra registrado");
            return false;
        }
    }

    private void checkCampos() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Error");
        builder.setMessage("Compruebe que los campos estan rellenos");
        builder.setPositiveButton("Aceptar", null);
        AlertDialog dialog = builder.create();
        dialog.show();
        Logger.t("CheckCampos").e("Los campos estan vacios");
    }

    private void showLogin() {
        /**Visible muestra el objeto y GONE oculta el objeto*/
        findViewById(R.id.login).setVisibility(View.VISIBLE);
        findViewById(R.id.add).setVisibility(View.VISIBLE);
        findViewById(R.id.register).setVisibility(View.GONE);
        findViewById(R.id.cancel).setVisibility(View.GONE);
    }

    private void showRegister() {
        findViewById(R.id.login).setVisibility(View.GONE);
        findViewById(R.id.add).setVisibility(View.GONE);
        findViewById(R.id.register).setVisibility(View.VISIBLE);
        findViewById(R.id.cancel).setVisibility(View.VISIBLE);
    }
}