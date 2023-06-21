package com.example.newapiactivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Apiinterface {

    @GET ("api")
    Call<List<Modelforapi>> getdata();
}
