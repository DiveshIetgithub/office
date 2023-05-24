package com.sanjay.calapplication.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUser {
    public static final String BASE_URL ="https://jsonplaceholder.typicode.com/";
     public static Retrofit retrofit = null;
     public static Retrofit getUser()
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
