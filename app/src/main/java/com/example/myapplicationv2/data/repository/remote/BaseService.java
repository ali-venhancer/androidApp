package com.example.myapplicationv2.data.repository.remote;

import io.reactivex.Observable;

import com.example.myapplicationv2.data.repository.remote.data.NewsResponse;


import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface BaseService {
    @Headers({"Content-Type:application/json","authorization:apikey 377GSqXQdTlywlZ1hFjYKQ:30ewgtaKqCu4HOcPuKtOs0"})
    @GET("getNews?country=tr&tag=general")
    Observable<NewsResponse> getNew();
}
