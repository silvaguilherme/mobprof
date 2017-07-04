package com.example.guilhermes.mobprof;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by guilherme.s on 23/06/2017.
 */

public class CriacaoProvaAleatoriaConfirmacao extends Fragment{

    Button buttonConfirmar;
    Button buttonCancelar;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Visualização da prova");

        buttonConfirmar = (Button) getView().findViewById(R.id.buttonConfirmar);
        buttonCancelar = (Button) getView().findViewById(R.id.buttonCancelar);

        buttonConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Prova confirmada com sucesso", Toast.LENGTH_LONG).show();
            }
        });

        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Prova cancelada", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.criacao_prova_aleatoria_confirmacao, container, false);
    }
}
