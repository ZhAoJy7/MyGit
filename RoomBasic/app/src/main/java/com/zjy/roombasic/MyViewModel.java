package com.zjy.roombasic;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MyViewModel extends AndroidViewModel {
    private WordDAO wordDAO;
//    private LiveData<List<Word>> allWordsLive;
    private WordRepository wordRepository;
    public MyViewModel(@NonNull Application application) {
        super(application);
//        WordDataBase wordDataBase=WordDataBase.getDataBase(application);
//        wordDAO=wordDataBase.getWordDAO();
        wordRepository=new WordRepository(application);
//        allWordsLive=wordDAO.getAllWordsLive();
    }


    public LiveData<List<Word>> getAllWordsLive() {
        return wordRepository.getAllWordsLive();
    }

    void InsertWords(Word...words){
//        new WordRepository.InsertAsyncTask(wordDAO).execute(words);
        wordRepository.InsertWords(words);
    }

    void UpdateWords(Word...words){
//        new WordRepository.UpdateAsyncTask(wordDAO).execute(words);
        wordRepository.UpdateWords(words);
    }
    void ClearWords(){
//        new WordRepository.ClearAsyncTask(wordDAO).execute();
        wordRepository.ClearWords();
    }
    void DeleteWords(Word...words){
//        new WordRepository.DeleteAsyncTask(wordDAO).execute(words);
        wordRepository.DeleteWords(words);
    }


}
