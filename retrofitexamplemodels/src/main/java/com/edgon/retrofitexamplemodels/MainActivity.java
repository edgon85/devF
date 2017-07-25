package com.edgon.retrofitexamplemodels;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.edgon.retrofitexamplemodels.adapter.ModelsAdapter;
import com.edgon.retrofitexamplemodels.interfaces.ServiceFenerator;
import com.edgon.retrofitexamplemodels.interfaces.ServicesInterfaces;
import com.edgon.retrofitexamplemodels.models.Models;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView myRecyclerView;
    private List<Models> listModels = new ArrayList<>();
    private ModelsAdapter modelsAdapter;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //loadData();
        loadDataSingleton();
    }


    //Cargar recycler
    private void inicializarRecyclerView(List<Models> lista) {
        myRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this);

        myRecyclerView.setLayoutManager(linearLayoutManager);

        modelsAdapter = new ModelsAdapter(lista);
        myRecyclerView.setAdapter(modelsAdapter);
    }

    private void loadDataSingleton() {
        ServicesInterfaces servicesInterfaces = ServiceFenerator.createServices();
        servicesInterfaces.loadData().enqueue(new Callback<List<Models>>() {
            @Override
            public void onResponse(Call<List<Models>> call, Response<List<Models>> response) {
                for (int i = 0; i < response.body().size(); i++) {
                    String title = response.body().get(i).getTitle();
                    Log.e("MyLog",title);
                }

                inicializarRecyclerView(response.body());
            }

            @Override
            public void onFailure(Call<List<Models>> call, Throwable t) {

            }
        });
    }

    public void  loadData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://beta.json-generator.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ServicesInterfaces cliente = retrofit.create(ServicesInterfaces.class);
        cliente.loadData().enqueue(new Callback<List<Models>>() {
            @Override
            public void onResponse(Call<List<Models>> call, Response<List<Models>> response) {

                for (int i = 0; i < response.body().size(); i++) {
                    String title = response.body().get(i).getTitle();
                    Log.e("MyLog",title);
                }
            }

            @Override
            public void onFailure(Call<List<Models>> call, Throwable t) {

            }
        });
    }
}
