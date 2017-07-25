package com.edgon.retrofitexamplemodels.interfaces;

import com.edgon.retrofitexamplemodels.models.Models;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by gonza on 7/19/2017.
 */

public interface ServicesInterfaces {

    //http://beta.json-generator.com/api/json/get/EkphH5xyM
    @GET("/api/json/get/EkphH5xyM")
    //se hace el call a la lista del modelo de ejemplos
    Call<List<Models>> loadData();

}
