package com.edgon.retrofit_recyclerview.api;

import com.edgon.retrofit_recyclerview.constants.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gonza on 7/20/2017.
 */

public class ServiceGenerator {

    private static Retrofit retrofit;

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.URL);

    public static ServicesInterfaces createServices(){
        if (retrofit == null){
            retrofit = builder.build();
        }

        return retrofit.create(ServicesInterfaces.class);
    }
}
