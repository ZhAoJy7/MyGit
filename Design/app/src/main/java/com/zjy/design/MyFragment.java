package com.zjy.design;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyFragment extends Fragment {

    Context mContext;
    RecyclerView recyclerView;
    String[] pictureUrls=new String[10];
    final List<Picture> pictureList=new ArrayList<>();

    //构造函数用于传参
    public MyFragment(){
        super();
    }

    public static MyFragment newInstance(){
        MyFragment f = new MyFragment();
        return f;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext=getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        recyclerView=new RecyclerView(mContext);
        return recyclerView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String url="https://pixabay.com/api/?key=15930789-8075548eff2edf87dc1c95dfc&q=all&image_type=photo&pretty=true";


        final RequestQueue requestQueue= Volley.newRequestQueue(getActivity());
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(JsonObjectRequest.Method.POST, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                String objects= null;
                JSONArray jsonArray=null;
                try {
                    objects = response.get("hits").toString();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    jsonArray = new JSONArray(objects);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                List lists = new ArrayList<>();
                final List listName=new ArrayList<>();

                for (int i = 0; i < 20; i++) {
                    try {
                        lists.add(i,jsonArray.getJSONObject(i).get("webformatURL"));
                        listName.add(i,jsonArray.getJSONObject(i).get("user"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                Random r=new Random();
                int number=0;
                for(int i=0;i<5;i++){
                    number = r.nextInt(20);
                    pictureUrls[i]=lists.get(number).toString();
                    final String username=listName.get(number).toString();
                    ImageRequest imageRequest=new ImageRequest(pictureUrls[i], new Response.Listener<Bitmap>() {
                        @Override
                        public void onResponse(Bitmap response) {
                            Picture picture=new Picture(username,response);
                            pictureList.add(picture);
                        }
                    }, 0, 0, ImageView.ScaleType.CENTER, Bitmap.Config.RGB_565, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            System.out.println(error);
                        }
                    });

                    requestQueue.add(imageRequest);
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);

            }
        });
        requestQueue.add(jsonObjectRequest);




        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        MyAdapter myAdapter=new MyAdapter(pictureList);
        recyclerView.setAdapter(myAdapter);
    }




}
