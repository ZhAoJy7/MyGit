package com.zjy.roombasic;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
//singleton
@Database(entities = {Word.class},version = 1,exportSchema = false)
public abstract class WordDataBase extends RoomDatabase {
    private static WordDataBase INSTANCE;
    static synchronized WordDataBase getDataBase(Context context){
        if(INSTANCE==null){
            INSTANCE= Room.databaseBuilder(context.getApplicationContext(),WordDataBase.class,"word_database")
//                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
    public abstract WordDAO getWordDAO();
}
