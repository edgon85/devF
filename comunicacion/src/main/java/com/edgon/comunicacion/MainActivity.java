package com.edgon.comunicacion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextDolar;
    private EditText editTextPeso;
    private Button btnDolar;
    private Button btnPeso;
    private Button btnComvertir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextDolar = (EditText) findViewById(R.id.editTextDolar);
        editTextPeso = (EditText) findViewById(R.id.editTextPesos);
        btnComvertir = (Button) findViewById(R.id.btn_comvertir);
        btnDolar = (Button) findViewById(R.id.btnDolar);
        btnPeso = (Button) findViewById(R.id.btnPeso);

        btnDolar.setOnClickListener(this);
        btnPeso.setOnClickListener(this);
        btnComvertir.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnDolar:
                //Toast.makeText(MainActivity.this,"Boton Dolar",Toast.LENGTH_LONG).show();
                String dolar = editTextDolar.getText().toString();
                if (!dolar.isEmpty()){
                    double dolares = Double.parseDouble(dolar);
                    double pesos = dolares*17.8;
                    editTextPeso.setText(pesos+"");
                    Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                    intent.putExtra("extra",pesos);
                    startActivity(intent);
                }

                break;

            case R.id.btnPeso:
                String pesos = editTextPeso.getText().toString();
                if (!pesos.isEmpty()){
                    double peso = Double.parseDouble(pesos);
                    double dol = peso * 0.17;
                    editTextDolar.setText(dol+"");
                    Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                    intent.putExtra("extra",dol);
                    startActivity(intent);
                }
                break;

            case R.id.btn_comvertir:
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                //intent.putExtra("extra",)
                startActivity(intent);
                break;
        }
    }
}
