package com.edgon.recyclerview_realm.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.edgon.recyclerview_realm.R;
import com.edgon.recyclerview_realm.adapters.ContactosAdapter;
import com.edgon.recyclerview_realm.models.Contactos;
import com.edgon.recyclerview_realm.realServices.RealmServices;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {

    private List<Contactos> contactos = new ArrayList<>();
    private RecyclerView listaContactos;
    private ContactosAdapter contactosAdapter;
    private CardView cardView;
    private FloatingActionButton floatAdd;

    RealmServices realmServices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        floatAdd = (FloatingActionButton) findViewById(R.id.fab_main);
        Realm.init(this);

        //Configurar la base de datos
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name("dbLogin")
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
        realmServices = new RealmServices(Realm.getDefaultInstance());

        agregarContacto();
        inicializarAdapter();

    }

    private void inicializarAdapter() {
        listaContactos = (RecyclerView) findViewById(R.id.recycler);
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this);

        listaContactos.setLayoutManager(linearLayoutManager);

        contactosAdapter = new ContactosAdapter(realmServices.obtenerUsuarios());
        listaContactos.setAdapter(contactosAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        contactosAdapter.notifyDataSetChanged();
    }

    private void agregarContacto(){
        floatAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

}
