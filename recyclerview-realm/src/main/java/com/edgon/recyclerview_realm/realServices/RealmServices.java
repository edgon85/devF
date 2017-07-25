package com.edgon.recyclerview_realm.realServices;

import com.edgon.recyclerview_realm.models.Contactos;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by gonza on 7/18/2017.
 */

public class RealmServices {
    Realm realm;

    public RealmServices(Realm realm) {
        this.realm = realm;
    }

    // insertar contacto
    public void insertContact(String name, String phone, String email){
        Contactos contactos = new Contactos();
        contactos.setName(name);
        contactos.setEmail(email);
        contactos.setPhone(phone);
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(contactos);
        realm.commitTransaction();
    }

    //Obtener usuarios
    public RealmResults<Contactos> obtenerUsuarios(){
        RealmResults<Contactos> listUsuarios = realm.where(Contactos.class).findAll();
        return listUsuarios;
    }

}
