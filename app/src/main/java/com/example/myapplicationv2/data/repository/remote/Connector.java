package com.example.myapplicationv2.data.repository.remote;


import com.example.myapplicationv2.data.repository.remote.data.NewsResponse;

import io.reactivex.Observable;

public class Connector extends BaseRemote{
    public Observable<NewsResponse> getNew(String url){
        return create(BaseService.class,url).getNew();
    }
}
