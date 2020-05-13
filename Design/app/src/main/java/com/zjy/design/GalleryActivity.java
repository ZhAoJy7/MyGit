package com.zjy.design;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

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

//    private RecyclerView recyclerView;
    ViewPager viewPager;
    private FloatingActionButton floatingActionButton;
    private BottomBar bottomBar;
    ArrayList<Fragment> fragments;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_gallery);

        viewPager=findViewById(R.id.viewPager);
        bottomBar=findViewById(R.id.bottomBar);

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(int tabId) {
            }
        });

        fragments=new ArrayList<>();
        fragments.add(new MyFragment());
        fragments.add(new AnimalFragment());
        fragments.add(new LandFragment());
        fragments.add(new PeopleFragment());
        fragments.add(new HomeFragment());

        viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(viewPagerAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        bottomBar.selectTabWithId(R.id.tab_gallery);
                        break;
                    case 1:
                        bottomBar.selectTabWithId(R.id.tab_animal);
                        break;
                    case 2:
                        bottomBar.selectTabWithId(R.id.tab_land);
                        break;
                    case 3:
                        bottomBar.selectTabWithId(R.id.tab_people);
                        break;
                    case 4:
                        bottomBar.selectTabWithId(R.id.tab_home);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(int tabId) {
                switch (tabId){
                    case R.id.tab_gallery:
                        viewPager.setCurrentItem(0,false);
                        break;
                    case R.id.tab_animal:
                        viewPager.setCurrentItem(1,false);
                        break;

                    case R.id.tab_land:
                        viewPager.setCurrentItem(2,false);
                        break;

                    case R.id.tab_people:
                        viewPager.setCurrentItem(3,false);
                        break;

                    case R.id.tab_home:
                        viewPager.setCurrentItem(4,false);
                        break;

                }
            }
        });
//        recyclerView=findViewById(R.id.recyclerView);
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


//        List<Picture> pictureList=new ArrayList<>();
//        Picture picture1=new Picture("adachai",R.drawable.ic_audiotrack_black_24dp);
//        Picture picture2=new Picture("777",R.drawable.ic_launcher_background);
//        pictureList.add(picture1);
//        pictureList.add(picture2);
//
//        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(linearLayoutManager);
//
//        MyAdapter myAdapter=new MyAdapter(pictureList);
//
//        recyclerView.setAdapter(myAdapter);
    }

}
