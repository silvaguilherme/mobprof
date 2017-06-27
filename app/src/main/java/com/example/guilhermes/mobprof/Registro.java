package com.example.guilhermes.mobprof;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Registro extends AppCompatActivity {

    EditText ET_CDTIPO, ET_DSTIPO;
    String dstipo, cdtipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        ET_CDTIPO = (EditText)findViewById(R.id.new_CDTIPO);
        ET_DSTIPO = (EditText)findViewById(R.id.new_DSTIPO);

    }
    public void userReg(View view){
        cdtipo = ET_CDTIPO.getText().toString();
        dstipo = ET_DSTIPO.getText().toString();
        String method = "Registro";

        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method, cdtipo, dstipo);
        finish();

    }

}
