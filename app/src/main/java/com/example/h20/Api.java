package com.example.h20;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {
    //base url
    //function
    @GET("marvel")
    Call<List<Hero>> gethero();

}
