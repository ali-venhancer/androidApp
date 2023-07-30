package com.example.myapplicationv2.ui.itemdetail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ItemDetailViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ItemDetailViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is item detail fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
