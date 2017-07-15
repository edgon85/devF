package com.edgon.tarea1semanacampusparty;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GenerarPasword extends AppCompatActivity {

    private EditText edtLongitud;
    private Button btnGenerarPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generar_pasword);

        edtLongitud = (EditText) findViewById(R.id.edt_longitud);
        btnGenerarPass = (Button) findViewById(R.id.btn_generar_pass);

        btnGenerarPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int longitud = Integer.parseInt(edtLongitud.getText().toString());

                if (!(longitud >= 9)) {
                    Toast.makeText(GenerarPasword.this, "Ingrese un numero mayor o igual a 9", Toast.LENGTH_SHORT).show();
                } else {
                    Password pass = new Password();

                    String newPassword = pass.generatePassword(longitud);
                    Log.e("MyLog", newPassword);

                    Intent returnIntent = new Intent();
                    returnIntent.putExtra(Constants.INTENT_PASSWORD,newPassword);
                    setResult(RESULT_OK,returnIntent);
                    finish();
                }
            }
        });


    }
}
