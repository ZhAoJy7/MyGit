package com.zjy.design;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
    UserDatabase userDatabase;
    UserDao userDao;
    EditText editText_email,editText_username,editText_password;
    Button btn_register,btn_toLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_register);
        userDatabase= Room.databaseBuilder(this,UserDatabase.class,"user_database").allowMainThreadQueries()
                .build();
        userDao=userDatabase.getUserDao();
        initView();
        initListener();
    }

    private void initView(){
        editText_email=findViewById(R.id.editText_password);
        editText_username=findViewById(R.id.editText_password);
        editText_password=findViewById(R.id.editText_password);
        btn_register=findViewById(R.id.button_login);
        btn_toLogin=findViewById(R.id.button_toRegister);
    }

    private void initData(){

    }

    private void initListener(){
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


}
