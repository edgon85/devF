package com.edgon.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.edgon.recyclerview.adapters.PesoAdapter;
import com.edgon.recyclerview.models.Peso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Peso> pesos = new ArrayList<>();
    private RecyclerView listaPesos;
    private PesoAdapter pesoAdapter;
    private CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardView = (CardView)findViewById(R.id.cardview);

        inicializarAdapter();
        initPeso();
    }

    private void initPeso() {
        pesos.add(new Peso("01/01/2018","78"));
        pesos.add(new Peso("02/01/2018","79"));
        pesos.add(new Peso("03/01/2018","72"));
        pesos.add(new Peso("04/01/2018","72"));
        pesos.add(new Peso("05/01/2018","74"));
        pesos.add(new Peso("06/01/2018","72"));
        pesos.add(new Peso("07/01/2018","73"));
        pesos.add(new Peso("08/01/2018","71"));
        pesos.add(new Peso("09/01/2018","75"));
        pesos.add(new Peso("01/01/2018","78"));
        pesos.add(new Peso("02/01/2018","79"));
        pesos.add(new Peso("03/01/2018","72"));
        pesos.add(new Peso("04/01/2018","73"));
        pesos.add(new Peso("05/01/2018","74"));
        pesos.add(new Peso("06/01/2018","72"));
        pesos.add(new Peso("07/01/2018","73"));
        pesos.add(new Peso("08/01/2018","71"));
        pesos.add(new Peso("09/01/2018","75"));
    }

    private void inicializarAdapter(){
        listaPesos = (RecyclerView) findViewById(R.id.recycler);
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this);

        listaPesos.setLayoutManager(linearLayoutManager);

        pesoAdapter = new PesoAdapter(pesos);
        listaPesos.setAdapter(pesoAdapter);
    }
}