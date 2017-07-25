package com.edgon.retrofitexamplemodels.interfaces;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gonza on 7/19/2017.
 */

public class ServiceFenerator {

    private static Retrofit retrofit;

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://beta.json-generator.com");

    public static ServicesInterfaces createServices(){
        if (retrofit == null){
            retrofit = builder.build();
        }
        return retrofit.create(ServicesInterfaces.class);
    }
}
