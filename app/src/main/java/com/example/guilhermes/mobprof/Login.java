package com.example.guilhermes.mobprof;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Login extends AppCompatActivity{

    EditText ET_NAME, ET_PASS;
    String matricula, senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ET_NAME = (EditText)findViewById(R.id.matricula);
        ET_PASS = (EditText)findViewById(R.id.senha);
    }

    public void userReg(View view) {
        startActivity(new Intent(this, Registro.class));
    }

    public void userLogin(View view){
        matricula = ET_NAME.getText().toString();
        senha = ET_PASS.getText().toString();
        String method = "Login";
        BackgroundTask backgroundtask = new BackgroundTask(this);
        backgroundtask.execute(method, matricula, senha);


    }

    }