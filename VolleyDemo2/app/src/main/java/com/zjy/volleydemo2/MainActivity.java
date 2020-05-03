package com.zjy.volleydemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button;
        button=findViewById(R.id.button);

        Intent intent=new Intent(this, VolleyActivity.class);
        this.startActivity(intent);
    }
}
