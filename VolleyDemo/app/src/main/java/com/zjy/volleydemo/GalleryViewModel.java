package com.zjy.volleydemo;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;


import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GalleryViewModel extends AndroidViewModel {

    private MutableLiveData<List<item>> _photoListLive;
    public LiveData<List<item>> photoListLive;

    public MutableLiveData<List<item>> get_photoListLive() {
        if(_photoListLive==null){
            _photoListLive=new MutableLiveData<>();
        }
        return _photoListLive;
    }

    public void fetchData(){
        StringRequest stringRequest=new StringRequest(
                StringRequest.Method.GET,
                getURL(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson=new Gson();
                        _photoListLive.setValue(new ArrayList<>(Arrays.asList(gson.fromJson(response,Pixabay.class).hits)));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("hello",error.toString());
                    }
                }
        );
        VolleySingleton.getInstance(getApplication()).getRequestQueue().add(stringRequest);
    }


    private String getURL(){
        return "https://pixabay.com/api/?key=15930789-8075548eff2edf87dc1c95dfc&q="+getKeyWords();
    }

    public String getKeyWords(){
        String[] keyWords={"food","flower","car","phone","animal","landscape"};
        Random random=new Random();
        int num=random.nextInt(keyWords.length);
        String key=keyWords[num];
        return key;
    }

    public GalleryViewModel(@NonNull Application application) {
        super(application);
    }
}
