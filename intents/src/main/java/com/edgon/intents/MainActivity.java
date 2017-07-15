package com.edgon.intents;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnOk, btnLlamada, btnStreet, buscarApp;
    private EditText txtUser;
    private Button btnLink;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOk = (Button) findViewById(R.id.button_ok);
        txtUser = (EditText) findViewById(R.id.txtUser);
        btnLink = (Button) findViewById(R.id.btn_link);
        btnLlamada = (Button) findViewById(R.id.btn_llamada);
        btnStreet = (Button) findViewById(R.id.btn_street);
        buscarApp = (Button) findViewById(R.id.btn_buscar_app);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtd = txtUser.getText().toString();
                if (txtd.isEmpty()){
                    Toast.makeText(v.getContext(),"Ingresa tu nombre",Toast.LENGTH_SHORT).show();
                }else {

                   // String txt = txtUser.getText().toString();
                    Intent intent = new Intent(v.getContext(), Main2Activity.class);
                   // intent.putExtra(Constants.INTENT_KEY_USERNAME, txt);
                    //startActivity(intent);
                    startActivityForResult(intent,Constants.REQUEST_CODE_SECOND_ACTIVITY);
                }
            }
        });

        btnLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirLink(v);
            }
        });

        btnLlamada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCall();
            }
        });

        btnStreet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("google.streetview:cbll=19.332273,-99.190092");
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });

        buscarApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escogerApp(v);
            }
        });
    }

    private void escogerApp(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        Intent choser = Intent.createChooser(intent,"Escoge una aplicacion");
        if (intent.resolveActivity(getPackageManager()) != null );{
            startActivity(choser);
        }
    }

    private void hacerLlamada(View view) {
        Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:5593487593"));
       // startActivity(intent);
    }

    private void abrirLink(View view) {
        String url = "http://google.com";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (Constants.REQUEST_CODE_SECOND_ACTIVITY == requestCode){
            if (resultCode == RESULT_OK){
                String resltTxt = data.getStringExtra(Constants.INTENT_SALUDO);
                Toast.makeText(MainActivity.this,"Request Code: " + requestCode +" - " +resltTxt,Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(MainActivity.this,"Back: " + resultCode,Toast.LENGTH_LONG).show();
            }
        }
    }

    public void onCall() {
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);

        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{Manifest.permission.CALL_PHONE},123);
        } else {
            startActivity(new Intent(Intent.ACTION_CALL).setData(Uri.parse("tel:12345678901")));
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {

            case 123:
                if ((grantResults.length > 0) && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    onCall();
                } else {
                    Log.d("TAG", "Call Permission Not Granted");
                }
                break;

            default:
                break;
        }
    }
}
