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

public class LoginActivity extends AppCompatActivity {

    UserDatabase userDatabase;
    UserDao userDao;
    EditText editText_username,editText_password;
    Button btn_login,btn_toRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);

        initView();
        initListener();

        userDatabase= Room.databaseBuilder(this,UserDatabase.class,"user_database").allowMainThreadQueries()
                .build();
        userDao=userDatabase.getUserDao();

    }

    private  void initView(){
        editText_username=findViewById(R.id.editText_username);
        editText_password=findViewById(R.id.editText_password);
        btn_login=findViewById(R.id.button_login);
        btn_toRegister=findViewById(R.id.button_toLogin);
    }

    private  void initData(){

    }

    private  void initListener(){
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=editText_username.getText().toString();
                String password=editText_password.getText().toString();
                login(username,password);
            }
        });

        btn_toRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    void login(String username,String password){
        User userLogin;
        userLogin=userDao.login(username,password);

        if(userLogin==null){
            Toast toast=Toast.makeText(LoginActivity.this,"用户名或密码输入错误，请重新输入",Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        if(userLogin.isBanned()){
            Toast toast=Toast.makeText(LoginActivity.this,"您的账号已经被封禁，请咨询管理员",Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        Bundle bundle=new Bundle();
        bundle.putString("username",userLogin.getUserName());
        if(userLogin.isAdmin()){
            Intent intent=new Intent(LoginActivity.this,AdminActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }else{
            Intent intent=new Intent(LoginActivity.this,GalleryActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }
}
