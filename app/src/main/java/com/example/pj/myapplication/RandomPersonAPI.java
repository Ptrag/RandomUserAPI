package com.example.pj.myapplication;

import com.example.pj.myapplication.model.JsonFeed;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Created by Pj on 24/02/2018.
 */

public interface RandomPersonAPI {

    String BASE_URL = "https://randomuser.me/";

    @Headers("Content-Type: application/json")
    @GET("api/?results=50")
    Call<JsonFeed> getData();
}
