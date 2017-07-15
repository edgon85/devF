package com.edgon.quizapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.edgon.quizapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResultadoFragment extends Fragment {

    int resultado;
    TextView txtRespuesta;

    public ResultadoFragment(int resultado) {
        // Required empty public constructor
        this.resultado = resultado;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_resultado, container, false);
        txtRespuesta = (TextView) view.findViewById(R.id.txt_respuesta);
        txtRespuesta.setText("Respuesta : " + resultado);
        return view;
    }

}

