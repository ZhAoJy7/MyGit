package com.zjy.roombasic;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao   //database access object
public interface WordDAO {
    @Insert
    void insertWords(Word... words);

    @Update
    void updateWords(Word... words);

    @Delete
    void deleteWords(Word... words);

    @Query("DELETE FROM WORD")
    void deleteWords();

    @Query("SELECT * FROM WORD ORDER BY ID DESC")
//    List<Word> getAllWords();
    LiveData<List<Word>> getAllWordsLive();
}