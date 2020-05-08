package com.zjy.design;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.UserData;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
//    UserDatabase userDatabase;
//    UserDao userDao;
    Button insert,delete,update,login;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        userDatabase= Room.databaseBuilder(this,UserDatabase.class,"user_database").allowMainThreadQueries()
//                .build();
//        userDao=userDatabase.getUserDao();
        initView();
        initListener();
    }

    private void initView(){
        insert=findViewById(R.id.button);
        delete=findViewById(R.id.button3);
        update=findViewById(R.id.button4);
        login=findViewById(R.id.button5);
        textView=findViewById(R.id.textView);
    }

    private void initData(){}

    private void initListener(){
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
//                login("adachai","123456");
            }
        });

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                User user1=new User("admin","123456","admin@qq.com",true,false);
//                User user2=new User("adachai","123456","adachai@qq.com",false,false);
//                userDao.insertUser(user1);
//                userDao.insertUser(user2);
//                updateView();
            }
        });
    }
    void login(String username,String password){
//        User userLogin=userDao.login(username,password);
//        String text="用户"+userLogin.getUserName()+"活跃状态为:"+String.valueOf(userLogin.isBanned())+"id为:"+userLogin.getId();
//        textView.setText(text);
    }
    void updateView(){
//        List<User> list=userDao.getAllUser();
        String text="";
//        for (int i=0;i<list.size();i++){
//            User user=list.get(i);
//            text+="用户"+user.getUserName()+"邮箱地址为:"+user.getEmailAddress()+"id为:"+user.getId();
//        }
//        textView.setText(text);
    }
}
