package com.zjy.volleydemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class VolleyActivity extends AppCompatActivity {

    private Button btn_get;
    private Button btn_post;
    private Button btn_json;
    private Button btn_request;
    private Button btn_loader;
    private Button btn_networkimageview;
    private ImageView imageView;
    private NetworkImageView networkImageView;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);

        initView();
        initData();
        initListener();
    }

    private void initListener() {
        btn_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue requestQueue= Volley.newRequestQueue(VolleyActivity.this);
//                String url="http://api.m.mtime.cn/PageSubArea/TrailerList.api";
                String url="http://10.0.2.2:8080/androidLogin?logname=root&password=123456";
                StringRequest stringRequest=new StringRequest(url, new Response.Listener<String>() {
                    //正确接收数据回调
                    @Override
                    public void onResponse(String response) {
                        textView.setText(response);
                    }
                }, new Response.ErrorListener() {
                    //发生异常进行回调
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textView.setText("加载失败"+error);
                    }
                });
                requestQueue.add(stringRequest);
            }
        });

        btn_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue requestQueue=Volley.newRequestQueue(VolleyActivity.this);
//                String url="http://api.m.mtime.cn/PageSubArea/TrailerList.api";
                String name="root";
                String psw="123456";
                String url="http://localhost:8080/androidLogin?logname=root&password=123456";
                String path="http://localhost:8080/androidLogin/login.jsp";
                StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        textView.setText(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textView.setText("加载失败"+error);
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> map=new HashMap<String,String>();
                        //map.put("value1","param1");
                        return map;
                    }
                };
                requestQueue.add(stringRequest);
            }
        });

        btn_json.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue requestQueue=Volley.newRequestQueue(VolleyActivity.this);
                String url="http://api.m.mtime.cn/PageSubArea/TrailerList.api";
                JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        textView.setText(response.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textView.setText("请求失败"+error);
                    }
                });
                requestQueue.add(jsonObjectRequest);
            }
        });
    }

    private void initData() {

    }

    private void initView() {
        btn_get=findViewById(R.id.button2);
        btn_post=findViewById(R.id.button3);
        btn_json=findViewById(R.id.button4);
        btn_request=findViewById(R.id.button5);
        btn_loader=findViewById(R.id.button6);
        btn_networkimageview=findViewById(R.id.button7);
        imageView=findViewById(R.id.imageView);
        networkImageView=findViewById(R.id.netWorkImageView);
        textView=findViewById(R.id.textView2);
    }
}
