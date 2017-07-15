package com.edgon.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtPantalla;
    private TextView txtPantalla2;
    private Button uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, cero, punto, igual, mas, menos, mult, div, del;
    private double cantidad1;
    private double cantidad2;
    private String signo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtPantalla = (TextView) findViewById(R.id.txt_pantalla);
        txtPantalla2 = (TextView) findViewById(R.id.txt_resultado);

        uno = (Button) findViewById(R.id.btn_uno);
        dos = (Button) findViewById(R.id.btn_dos);
        tres = (Button) findViewById(R.id.btn_tres);
        cuatro = (Button) findViewById(R.id.btn_cuatro);
        cinco = (Button) findViewById(R.id.btn_cinco);
        seis = (Button) findViewById(R.id.btn_seis);
        siete = (Button) findViewById(R.id.btn_siete);
        ocho = (Button) findViewById(R.id.btn_ocho);
        nueve = (Button) findViewById(R.id.btn_nueve);
        cero = (Button) findViewById(R.id.btn_cero);
        punto = (Button) findViewById(R.id.btn_punto);
        igual = (Button) findViewById(R.id.btn_igual);
        mas = (Button) findViewById(R.id.btn_mas);
        menos = (Button) findViewById(R.id.btn_menos);
        mult = (Button) findViewById(R.id.btn_mult);
        div = (Button) findViewById(R.id.btn_div);
        del = (Button) findViewById(R.id.btn_del);

        uno.setOnClickListener(this);
        dos.setOnClickListener(this);
        tres.setOnClickListener(this);
        cuatro.setOnClickListener(this);
        cinco.setOnClickListener(this);
        seis.setOnClickListener(this);
        siete.setOnClickListener(this);
        ocho.setOnClickListener(this);
        nueve.setOnClickListener(this);
        cero.setOnClickListener(this);
        punto.setOnClickListener(this);
        igual.setOnClickListener(this);
        mas.setOnClickListener(this);
        menos.setOnClickListener(this);
        mult.setOnClickListener(this);
        div.setOnClickListener(this);
        del.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_cero:
                if (txtPantalla.equals("")) {
                    txtPantalla.setText("0");
                } else {
                    txtPantalla.setText(txtPantalla.getText() + "0");
                }
                break;
            case R.id.btn_uno:
                if (txtPantalla.equals("")) {
                    txtPantalla.setText("1");
                } else {
                    txtPantalla.setText(txtPantalla.getText() + "1");
                }
                break;
            case R.id.btn_dos:
                if (txtPantalla.equals("")) {
                    txtPantalla.setText("2");
                } else {
                    txtPantalla.setText(txtPantalla.getText() + "2");
                }
                break;
            case R.id.btn_tres:
                if (txtPantalla.equals("")) {
                    txtPantalla.setText("3");
                } else {
                    txtPantalla.setText(txtPantalla.getText() + "3");
                }
                break;
            case R.id.btn_cuatro:
                if (txtPantalla.equals("")) {
                    txtPantalla.setText("4");
                } else {
                    txtPantalla.setText(txtPantalla.getText() + "4");
                }
                break;
            case R.id.btn_cinco:
                if (txtPantalla.equals("")) {
                    txtPantalla.setText("5");
                } else {
                    txtPantalla.setText(txtPantalla.getText() + "5");
                }
                break;
            case R.id.btn_seis:
                if (txtPantalla.equals("")) {
                    txtPantalla.setText("6");
                } else {
                    txtPantalla.setText(txtPantalla.getText() + "6");
                }
                break;
            case R.id.btn_siete:
                if (txtPantalla.equals("")) {
                    txtPantalla.setText("7");
                } else {
                    txtPantalla.setText(txtPantalla.getText() + "7");
                }
                break;
            case R.id.btn_ocho:
                if (txtPantalla.equals("")) {
                    txtPantalla.setText("8");
                } else {
                    txtPantalla.setText(txtPantalla.getText() + "8");
                }
                break;
            case R.id.btn_nueve:
                if (txtPantalla.equals("")) {
                    txtPantalla.setText("9");
                } else {
                    txtPantalla.setText(txtPantalla.getText() + "9");
                }
                break;
            case R.id.btn_punto:
                if (txtPantalla.equals("")) {
                    txtPantalla.setText(".");
                } else {
                    txtPantalla.setText(txtPantalla.getText() + ".");
                    punto.setEnabled(false);
                }
                break;
            case R.id.btn_del:
                txtPantalla.setText("");
                txtPantalla2.setText("");
                signo="";
                punto.setEnabled(true);

                break;

            case  R.id.btn_mas:
                cantidad1 = Double.parseDouble(txtPantalla.getText().toString());
                txtPantalla2.setText(cantidad1 + " + ");
                signo = "+";
                txtPantalla.setText("");
                break;

            case  R.id.btn_menos:
                cantidad1 = Double.parseDouble(txtPantalla.getText().toString());
                txtPantalla2.setText(cantidad1 + " - ");
                signo = "-";
                txtPantalla.setText("");
                break;
            case  R.id.btn_mult:
                cantidad1 = Double.parseDouble(txtPantalla.getText().toString());
                txtPantalla2.setText(cantidad1 + " x ");
                signo = "*";
                txtPantalla.setText("");
                break;
            case  R.id.btn_div:
                cantidad1 = Double.parseDouble(txtPantalla.getText().toString());
                txtPantalla2.setText(cantidad1 + " / ");
                signo = "/";
                txtPantalla.setText("");
                break;

            case R.id.btn_igual:
                cantidad2 = Double.parseDouble(txtPantalla.getText().toString());

                if (signo.equals("+")){
                    double total = cantidad1 + cantidad2;
                    txtPantalla2.setText(txtPantalla2.getText() +" " +txtPantalla.getText());
                    txtPantalla.setText(total+"");
                }else
                if (signo.equals("-")){
                    double total = cantidad1 - cantidad2;
                    txtPantalla2.setText(txtPantalla2.getText() +" " +txtPantalla.getText());
                    txtPantalla.setText(total+"");
                }else
                if (signo.equals("*")){
                    double total = cantidad1 * cantidad2;
                    txtPantalla2.setText(txtPantalla2.getText() +" " +txtPantalla.getText());
                    txtPantalla.setText(total+"");
                }else
                if (signo.equals("/")){
                    double total = cantidad1 / cantidad2;
                    txtPantalla2.setText(txtPantalla2.getText() +" " +txtPantalla.getText());
                    txtPantalla.setText(total+"");
                }
                break;
        }
    }
}
