package com.edgon.retrofit_recyclerview.api;

import com.edgon.retrofit_recyclerview.constants.Constants;
import com.edgon.retrofit_recyclerview.models.ListaContactos;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ServicesInterfaces {

    @GET(Constants.URI)
    Call<ListaContactos> loadData();
}
