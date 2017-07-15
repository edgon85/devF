package com.edgon.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView username = (TextView) findViewById(R.id.txt_dato);
        Button btn1 = (Button) findViewById(R.id.btn1);
/*
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            String user = bundle.getString(Constants.INTENT_KEY_USERNAME);
            username.setText(user);
        }*/

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra(Constants.INTENT_SALUDO,"Hola");
                setResult(RESULT_OK,returnIntent);
                finish();
            }
        });

    }
}
