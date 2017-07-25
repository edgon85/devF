package com.edgon.retrofit_recyclerview.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ListaContactos {

    @SerializedName("contactos")
    private List<Contactos> contactos = null;

    public List<Contactos> getContactos() {
        return contactos;
    }

    public void setContactos(List<Contactos> contactos) {
        this.contactos = contactos;
    }
}
