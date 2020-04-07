package com.jiyang.zhao.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AnotherActivity extends AppCompatActivity {

    private TextView tv;
    private TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        Intent i=getIntent();
        tv=findViewById(R.id.text_tv);
        tv.setText("我的体重是"+i.getStringExtra("weight"));
        tv2=findViewById(R.id.text_tv2);
        tv2.setText("我的年龄是"+i.getIntExtra("year",0)+"岁");
    }
}
