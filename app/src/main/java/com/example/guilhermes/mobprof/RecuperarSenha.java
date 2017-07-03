package com.example.guilhermes.mobprof;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RecuperarSenha extends AppCompatActivity {
    EditText ET_CDTIPO, ET_DSTIPO;
    String dstipo, cdtipo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_senha);
    }

    public void userRescue(View view) {
       // cdtipo = ET_CDTIPO.getText().toString();
        //dstipo = ET_DSTIPO.getText().toString();
       // String method = "Registro";

        //BackgroundTask backgroundTask = new BackgroundTask(this);
        //backgroundTask.execute(method, cdtipo, dstipo);

        Toast.makeText(getApplicationContext(), "Informações Enviadas Por E-Mail", Toast.LENGTH_SHORT).show();
        finish();
        finish();

    }

}