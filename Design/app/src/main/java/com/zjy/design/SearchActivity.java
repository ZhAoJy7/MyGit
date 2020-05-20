package com.zjy.design;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

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

public class SearchActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    EditText editText;
    Button button_search;
    Button button_back;

    String[] pictureUrls=new String[10];
    String tag;
    final List<Picture> pictureList=new ArrayList<>();

    String url="https://pixabay.com/api/?key=15930789-8075548eff2edf87dc1c95dfc&q=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        final RequestQueue requestQueue= Volley.newRequestQueue(SearchActivity.this);

        recyclerView=findViewById(R.id.recyclerView);
        editText=findViewById(R.id.editText);
        button_back=findViewById(R.id.button_back);
        button_search=findViewById(R.id.button_search);


        button_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tag=editText.getText().toString();
                JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(JsonObjectRequest.Method.POST, url+tag, null, new Response.Listener<JSONObject>() {
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
                        for (int i = 0; i < 5; i++) {
                            try {
                                lists.add(i,jsonArray.getJSONObject(i).get("webformatURL"));
                                listName.add(i,jsonArray.getJSONObject(i).get("user"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        for(int i=0;i<5;i++){
                            pictureUrls[i]=lists.get(i).toString();
                            final String username=listName.get(i).toString();
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
                LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(linearLayoutManager);
                MyAdapter myAdapter=new MyAdapter(pictureList);
                recyclerView.setAdapter(myAdapter);
            }
        });
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SearchActivity.this,GalleryActivity.class);
                startActivity(intent);
            }
        });
    }


}
