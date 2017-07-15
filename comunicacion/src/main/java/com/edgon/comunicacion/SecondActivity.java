package com.edgon.comunicacion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView = (TextView) findViewById(R.id.txt_dato);

        Bundle extra = getIntent().getExtras();
        double var = extra.getDouble("extra");
        textView.setText(var+"");



    }
}
