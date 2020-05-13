package com.zjy.design;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarTab;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;
import com.roughike.bottombar.TabSelectionInterceptor;


import java.util.ArrayList;
import java.util.List;

public class GalleryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FloatingActionButton floatingActionButton;

    private BottomBar bottomBar;
    private BottomBarTab gallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_gallery);

        bottomBar=findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(int tabId) {
                if(tabId==R.id.tab_gallery){
                    gallery=bottomBar.getTabWithId(R.id.tab_gallery);

                }
            }
        });


        recyclerView=findViewById(R.id.recyclerView);
        floatingActionButton=findViewById(R.id.fab);

        final MediaPlayer mediaPlayer;
        mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.bgm);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }else{
                    mediaPlayer.start();
                }
            }
        });


        List<Picture> pictureList=new ArrayList<>();
        Picture picture1=new Picture("adachai",R.drawable.ic_audiotrack_black_24dp);
        Picture picture2=new Picture("777",R.drawable.ic_launcher_background);
        pictureList.add(picture1);
        pictureList.add(picture2);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        MyAdapter myAdapter=new MyAdapter(pictureList);

        recyclerView.setAdapter(myAdapter);
    }

}
