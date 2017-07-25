package com.edgon.recyclerview_realm.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.edgon.recyclerview_realm.R;
import com.edgon.recyclerview_realm.realServices.RealmServices;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class RegisterActivity extends AppCompatActivity {

    private EditText edtNameRegistro, edtPhoneRegistro, edtEmailRegistro;
    private Button btnGuardarRegistro;
    RealmServices realmServices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edtNameRegistro = (EditText) findViewById(R.id.edt_name_registro);
        edtPhoneRegistro = (EditText) findViewById(R.id.edt_phone_registro);
        edtEmailRegistro = (EditText) findViewById(R.id.edt_email_registro);
        btnGuardarRegistro = (Button) findViewById(R.id.btn_guardar_registro);
        Realm.init(this);

        //Configurar la base de datos
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name("dbLogin")
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
        realmServices = new RealmServices(Realm.getDefaultInstance());

        btnGuardarRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarUsuario(edtNameRegistro.getText().toString(),
                        edtPhoneRegistro.getText().toString(),
                        edtEmailRegistro.getText().toString());

                finish();
            }
        });
    }

    private void registrarUsuario(String name, String phone, String email) {
        realmServices.insertContact(name,phone,email);
    }
}
