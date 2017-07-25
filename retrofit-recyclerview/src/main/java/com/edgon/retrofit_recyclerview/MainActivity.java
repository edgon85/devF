package com.edgon.retrofit_recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.edgon.retrofit_recyclerview.adapter.ContactosAdapter;
import com.edgon.retrofit_recyclerview.api.ServiceGenerator;
import com.edgon.retrofit_recyclerview.api.ServicesInterfaces;
import com.edgon.retrofit_recyclerview.models.Contactos;
import com.edgon.retrofit_recyclerview.models.ListaContactos;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<Contactos> contactos = new ArrayList<>();
    private RecyclerView listaContactos;
    private ContactosAdapter contactosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadDataSingleton();

        Log.e("MyLog","inicio");
    }

    private void loadDataSingleton() {
        ServicesInterfaces servicesInterfaces =
                ServiceGenerator.createServices();

        servicesInterfaces.loadData().enqueue(new Callback<ListaContactos>() {
            @Override
            public void onResponse(Call<ListaContactos> call, Response<ListaContactos> response) {
                Log.e("MyLog",response.toString());
            }

            @Override
            public void onFailure(Call<ListaContactos> call, Throwable t) {

            }
        });
    }

    private void inicializarAdapter(List<Contactos> list) {
        listaContactos = (RecyclerView) findViewById(R.id.recycler);
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listaContactos.setLayoutManager(linearLayoutManager);
        contactosAdapter = new ContactosAdapter(list);
        listaContactos.setAdapter(contactosAdapter);
    }
}