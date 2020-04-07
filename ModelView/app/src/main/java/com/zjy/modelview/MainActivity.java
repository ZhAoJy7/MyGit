package com.zjy.modelview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MyViewModel myViewModel;
    TextView tv;
    Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myViewModel= ViewModelProviders.of(this).get(MyViewModel.class);
        tv=findViewById(R.id.textView);
        tv.setText(String.valueOf(myViewModel.number));


        btn1=findViewById(R.id.button);
        btn2=findViewById(R.id.button2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.number++;
                tv.setText(String.valueOf(myViewModel.number));
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.number+=2;
                tv.setText(String.valueOf(myViewModel.number));
            }
        });
    }
}
