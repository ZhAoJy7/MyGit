package com.zjy.roombasic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn_insert,btn_clear;
    RecyclerView recyclerView;
    Switch switch_card;
    MyAdapter myAdapter1,myAdapter2;
    MyViewModel myViewModel;
    String[] Chinese={"一","二","三","四","五","六六六"};
    String[] English={"one","two","three","four","five","sixsixsix"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.RecyclerView);
        switch_card=findViewById(R.id.switch_card);

        myAdapter1=new MyAdapter(false);
        myAdapter2=new MyAdapter(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter1);

        myViewModel= ViewModelProviders.of(this).get(MyViewModel.class);
        switch_card.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    recyclerView.setAdapter(myAdapter2);
                }else{
                    recyclerView.setAdapter(myAdapter1);
                }
            }
        });
        myViewModel.getAllWordsLive().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
                myAdapter1.setAllWords(words);
                myAdapter2.setAllWords(words);
                myAdapter1.notifyDataSetChanged();
                myAdapter2.notifyDataSetChanged();

            }
        });

        btn_insert=findViewById(R.id.button_insert);
//        btn_update=findViewById(R.id.button_update);
        btn_clear=findViewById(R.id.button_clear);
//        btn_delete=findViewById(R.id.button4);

        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<Chinese.length;i++){
                    Word temp=new Word(Chinese[i],English[i]);
                    myViewModel.InsertWords(temp);
                }
            }
        });

//        btn_delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Word word=new Word("Hi","nihaoa");
//                word.setId(119);
////                wordDAO.updateWords(word);
////                new UpdateAsyncTask(wordDAO).execute(word);
//                myViewModel.DeleteWords(word);
//            }
//        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.ClearWords();
            }
        });

//        btn_update.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Word word=new Word("Hi","nihaoa");
//                word.setId(118);
////                wordDAO.updateWords(word);
////                new DeleteAsyncTask(wordDAO).execute(word);
//                myViewModel.UpdateWords(word);
//            }
//        });
    }


}
