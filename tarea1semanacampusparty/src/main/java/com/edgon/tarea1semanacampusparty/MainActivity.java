package com.edgon.tarea1semanacampusparty;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private EditText edtPassword;
    private Button btnLogin;
    private TextView txtGenerarPassword;
    ArrayList<String> passwordList = new ArrayList<>();

    Password password = new Password();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarVistas();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int x=0;x<passwordList.size();x++) {
                    Log.e("MyLog - Lista",passwordList.get(x));
                }
                if (edtPassword.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Ingrese una contraseña", Toast.LENGTH_SHORT).show();
                }else{
                    buscarPassword(edtPassword.getText().toString());
                }
            }
        });

        txtGenerarPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), GenerarPasword.class);
                startActivityForResult(intent,Constants.REQUEST_CODE_SECOND_ACTIVITY);
            }
        });
    }

    private void iniciarVistas() {
        edtPassword =(EditText) findViewById(R.id.edt_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
        txtGenerarPassword = (TextView) findViewById(R.id.txt_generar_password);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (Constants.REQUEST_CODE_SECOND_ACTIVITY == requestCode){
            if (resultCode == RESULT_OK){
                String resltTxt = data.getStringExtra(Constants.INTENT_PASSWORD);
                Toast.makeText(MainActivity.this,"Request Code: " + requestCode +" - " +resltTxt,Toast.LENGTH_LONG).show();
                passwordList.add(0,resltTxt);

            }else{
                Toast.makeText(MainActivity.this,"Back: " + resultCode,Toast.LENGTH_LONG).show();
            }
        }
    }

    public void buscarPassword(String password) {

        for(String pass: passwordList) {
            if (passwordList.isEmpty()){
                Toast.makeText(this, "No existen contraseñas", Toast.LENGTH_SHORT).show();
            }else if(pass.contains(password)) {
                //Log.e("MyLog ------->",pass.toString());
                String contrasenia = pass.toString();
                Intent intent = new Intent(MainActivity.this,ShowPasswod.class);
                intent.putExtra(Constants.INTENT_PASSWORD,contrasenia);
                startActivity(intent);
                finish();
            }else{
                Log.e("MyLog ------->","No existe");
                Toast.makeText(this, "No existe contraseña", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
