package com.zjy.design;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class AdminActivity extends AppCompatActivity {

    UserDatabase userDatabase;
    UserDao userDao;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);


        userDatabase= Room.databaseBuilder(this,UserDatabase.class,"user_database").allowMainThreadQueries()
                .build();
        userDao=userDatabase.getUserDao();

        recyclerView=findViewById(R.id.recyclerView);

        init();

    }
    private void init(){
        List<User> userList;
        userList=userDao.getAllUser();
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        UserAdapter userAdapter=new UserAdapter(userList);
        recyclerView.setAdapter(userAdapter);
    }

    private void ban(){


    }
}
