package com.sanjay.calapplication.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiOtp {
    public static final String BASE_URL ="https://japi.instaalerts.zone/httpapi/";
    public static Retrofit retrofit = null;
    public static Retrofit getOtp()
    {
        if(retrofit== null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
