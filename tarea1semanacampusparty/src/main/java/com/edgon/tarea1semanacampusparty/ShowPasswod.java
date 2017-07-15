package com.edgon.tarea1semanacampusparty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowPasswod extends AppCompatActivity {

    TextView txtRecibePassword;
    TextView txtSegura;
    Button btnLogOut;
    Password segura = new Password();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_passwod);

        txtRecibePassword = (TextView) findViewById(R.id.txt_recibe_password);
        txtSegura = (TextView) findViewById(R.id.txt_segura);
        btnLogOut = (Button) findViewById(R.id.btn_logout);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            String password = bundle.getString(Constants.INTENT_PASSWORD);
            txtRecibePassword.setText(password);
            txtSegura.setText("Su contrasena es segura: "+segura.esFuerte(password));
            //segura.esFuerte(password);
        }

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowPasswod.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
