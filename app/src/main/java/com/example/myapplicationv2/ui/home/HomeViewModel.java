package com.example.myapplicationv2.ui.home;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplicationv2.BuildConfig;
import com.example.myapplicationv2.data.repository.remote.Connector;
import com.example.myapplicationv2.data.repository.remote.DataResultCallBack;
import com.example.myapplicationv2.data.repository.remote.data.NewsResponse;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.Observable;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    Connector connector;

    public HomeViewModel() {

        connector = new Connector();
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public void getNews(DataResultCallBack callBack) {
        Observable<NewsResponse> observePosted = connector.getNew(BuildConfig.APIURL);
        observePosted.subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Consumer<NewsResponse>() {
                    @Override
                    public void accept(NewsResponse response) {
                        callBack.result(response);


                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {

                    }
                });
    }
}