package com.example.cerebro;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("latest")
    Call<Root> getposts();

}
