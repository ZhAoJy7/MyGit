package com.zjy.design;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.FragmentTransaction;
import android.content.Intent;
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
    static ArrayList<Fragment> fragments;
    ViewPagerAdapter viewPagerAdapter;
    MyFragment myFragment=new MyFragment();
    AnimalFragment animalFragment=new AnimalFragment();
    LandFragment landFragment=new LandFragment();
    PeopleFragment peopleFragment=new PeopleFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_gallery);

        viewPager=findViewById(R.id.viewPager);
        bottomBar=findViewById(R.id.bottomBar);

        fragments=new ArrayList<>();
        fragments.add(myFragment);
        fragments.add(animalFragment);
        fragments.add(landFragment);
        fragments.add(peopleFragment);
        fragments.add(new HomeFragment());

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(int tabId) {
            }
        });
        bottomBar.setOnTabReselectListener(new OnTabReselectListener() {
            @Override
            public void onTabReSelected(int tabId) {
//                switch (tabId){
//                    case R.id.tab_gallery:
//                        myFragment=new MyFragment();
//                        fragments.set(0,myFragment);
//                        viewPagerAdapter.notifyDataSetChanged();
//                        viewPager.setAdapter(viewPagerAdapter);
//                        viewPager.setOffscreenPageLimit(5);
//
//                        break;
//
//                }
            }
        });


        viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setOffscreenPageLimit(7);

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

        floatingActionButton=findViewById(R.id.fab);

//        final MediaPlayer mediaPlayer;
//        mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.bgm);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(mediaPlayer.isPlaying()){
//                    mediaPlayer.stop();
//                }else{
//                    mediaPlayer.start();
//                }
                Intent intent=new Intent(GalleryActivity.this,SearchActivity.class);
                startActivity(intent);
            }
        });


    }

}
