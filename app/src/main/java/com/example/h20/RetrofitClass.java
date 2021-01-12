package com.example.h20;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitClass {

    private static RetrofitClass instance = null;
    private Api myApi;
    //base url
    private static final String api_base_url = "https://simplifiedcoding.net/demos/";

    private RetrofitClass() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(api_base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi = retrofit.create(Api.class);
    }
    public static synchronized RetrofitClass getInstance() {
        if (instance == null) {
            instance = new RetrofitClass();
        }
        return instance;
    }

    public Api getMyApi() {
        return myApi;
    }
}
