package com.zjy.design;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    Context mContext;
    UserDatabase userDatabase;
    UserDao userDao;
    private RecyclerView recyclerView;

    //构造函数用于传参
    public HomeFragment(){
        super();
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext=getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        recyclerView=new RecyclerView(mContext);
        return recyclerView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }

    private void init(){
        userDatabase= Room.databaseBuilder(getContext(),UserDatabase.class,"user_database").allowMainThreadQueries()
                .build();
        userDao=userDatabase.getUserDao();

        List<User> userList;
        userList=userDao.getAllUser();
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        FriendsAdapter friendsAdapter=new FriendsAdapter(userList);
        recyclerView.setAdapter(friendsAdapter);
    }
}
