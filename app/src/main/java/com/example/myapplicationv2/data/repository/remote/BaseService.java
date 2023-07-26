package com.example.myapplicationv2.data.repository.remote;

import io.reactivex.Observable;

import com.example.myapplicationv2.data.repository.remote.data.NewsResponse;


import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface BaseService {
    @Headers({"Content-Type:application/json","authorization:apikey 6miu2byuDOz7qHZNJRXZHE:0R9r2DNIqkfE136vrnakwT"})
    @GET("getNews?country=tr&tag=general")
    Observable<NewsResponse> getNew();
}
