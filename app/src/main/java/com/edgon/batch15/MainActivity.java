package com.edgon.batch15;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonOK;
    private EditText ingreseNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("log","CREATE");
        buttonOK = (Button) findViewById(R.id.button_ok);
        ingreseNombre = (EditText) findViewById(R.id.ingresa_nombre);

//        buttonOK.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.e("Click","Click");
//            }
//        });
        buttonOK.setOnClickListener(this);

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("log","STOP");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("log","RESUME");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("log","PAUSE");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("log","DESTROY");
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_ok:
                Log.e("MyLog",ingreseNombre.getText().toString());
                break;
        }
    }
}
