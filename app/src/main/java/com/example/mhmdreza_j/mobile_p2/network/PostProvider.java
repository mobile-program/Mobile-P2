package com.example.mhmdreza_j.mobile_p2.network;


import com.example.mhmdreza_j.mobile_p2.Post;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostProvider {

    private PostService service;

    public PostProvider() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .client(new OkHttpClient())
                .build();
        service = retrofit.create(PostService.class);
    }

    public PostService getService() {
        return service;
    }
}
