package com.example.newapiactivity;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    String URL = "https://randomuser.me/api/";
    Apiinterface apiinterface;
    static RetrofitInstance instance;
    public RetrofitInstance(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiinterface = retrofit.create(Apiinterface.class);
    }

    public static synchronized RetrofitInstance getinstance(){
        if(instance == null){
            instance = new RetrofitInstance();
        }
        return instance;
    }
    public Apiinterface api(){

        return apiinterface;
    }
}
