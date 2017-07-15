package com.edgon.ejercicio1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etIngresoNumeros;
    private Button btnconsultar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etIngresoNumeros = (EditText) findViewById(R.id.txt_ingreso);
        btnconsultar = (Button) findViewById(R.id.btn_contar);

        btnconsultar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                caluclar();
            }
        });

    }

    private void caluclar() {
        String texto = etIngresoNumeros.getText().toString();
        String var[] = texto.split(",");
        for (int i=0;i<var.length;i++){
            Log.e("======> ","" + i);
        }

    }
}
