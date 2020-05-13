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

import java.util.ArrayList;
import java.util.List;

public class LandFragment extends Fragment {
    Context mContext;
    RecyclerView recyclerView;

    //构造函数用于传参
    public LandFragment(){
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
        Picture picture1=new Picture("Land",R.drawable.ic_audiotrack_black_24dp);
        Picture picture2=new Picture("Land",R.drawable.ic_launcher_background);
        List<Picture> pictureList=new ArrayList<>();
        pictureList.add(picture1);
        pictureList.add(picture2);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        MyAdapter myAdapter=new MyAdapter(pictureList);
        recyclerView.setAdapter(myAdapter);
    }
}
