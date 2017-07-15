package com.edgon.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private List<String> miListaSaludos = new ArrayList<>();
    private MyFragment myFragment;
    private int posSaludo = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        saludo();
        cambiarFragment(posSaludo);

    }

    private void cambiarFragment(int position){
        myFragment = new MyFragment(miListaSaludos.get(position));
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frame_layout,myFragment)
                .commit();
    }

    private void initView(){
        Button btnNext = (Button) findViewById(R.id.btn_next);

        btnNext.setOnClickListener(this);
    }

    private void saludo(){
        miListaSaludos.add("Hola");
        miListaSaludos.add("Hi");
        miListaSaludos.add("Hello");
        miListaSaludos.add("Que onda");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_next:
                    cambiarFragment(posSaludo++);
               // if (posSaludo>=4){
               //     posSaludo = 0;
               // }

                if (miListaSaludos.size() >= 4){
                    posSaludo = 0;
                }
                break;
        }
    }
}
