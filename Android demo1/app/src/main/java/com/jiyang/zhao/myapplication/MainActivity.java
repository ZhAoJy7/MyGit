package com.jiyang.zhao.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnStartAnotherAty).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this,LoginActivity.class));
//                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.baidu.com")));
                Intent i=new Intent(MainActivity.this,AnotherActivity.class);
//                i.putExtra("weight","80kg");
                Bundle b=new Bundle();
                b.putString("weight","80kg");
//                b.putInt("age",22);
                i.putExtras(b);
                startActivity(i);
            }
        });
    }
}
