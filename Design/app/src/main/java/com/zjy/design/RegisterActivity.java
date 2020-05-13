package com.zjy.design;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        editText_email=findViewById(R.id.editText_email);
        editText_username=findViewById(R.id.editText_username);
        editText_password=findViewById(R.id.editText_password);
        btn_register=findViewById(R.id.button_login);
        btn_toLogin=findViewById(R.id.button_toLogin);
    }

    private void initData(){

    }

    private void initListener(){
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=editText_email.getText().toString();
                String username=editText_username.getText().toString();
                String password=editText_password.getText().toString();
                User userRegister = new User(username,password,email,false,false);

                if(userRegister.getEmailAddress()==null||userRegister.getUserName()==null||userRegister.getPassword()==null){
                    Toast toast=Toast.makeText(RegisterActivity.this,"请正确填写注册信息",Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
                userDao.insertUser(userRegister);
                Toast toast=Toast.makeText(RegisterActivity.this,"恭喜您成功注册",Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        btn_toLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }

}
