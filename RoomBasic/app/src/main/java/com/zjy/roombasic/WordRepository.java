package com.zjy.roombasic;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WordRepository {
    private LiveData<List<Word>>allWordsLive;
    private WordDAO wordDAO;

    public WordRepository(Context context){
        WordDataBase wordDataBase=WordDataBase.getDataBase(context.getApplicationContext());
        wordDAO=wordDataBase.getWordDAO();
        allWordsLive=wordDAO.getAllWordsLive();
    }
    public LiveData<List<Word>> getAllWordsLive() {
        return allWordsLive;
    }

    static class InsertAsyncTask extends AsyncTask<Word,Void,Void> {
        private WordDAO wordDAO;

        public InsertAsyncTask(WordDAO wordDAO) {
            this.wordDAO = wordDAO;
        }

        @Override
        protected Void doInBackground(Word... words) {
            wordDAO.insertWords(words);
            return null;
        }
    }

    static class UpdateAsyncTask extends AsyncTask<Word,Void,Void> {
        private WordDAO wordDAO;

        public UpdateAsyncTask(WordDAO wordDAO) {
            this.wordDAO = wordDAO;
        }

        @Override
        protected Void doInBackground(Word... words) {
            wordDAO.updateWords(words);
            return null;
        }
    }

    static class ClearAsyncTask extends AsyncTask<Void,Void,Void>{
        private WordDAO wordDAO;

        public ClearAsyncTask(WordDAO wordDAO) {
            this.wordDAO = wordDAO;
        }

        @Override
        protected Void doInBackground(Void... Voids) {
            wordDAO.deleteWords();
            return null;
        }
    }

    static class DeleteAsyncTask extends AsyncTask<Word,Void,Void>{
        private WordDAO wordDAO;

        public DeleteAsyncTask(WordDAO wordDAO) {
            this.wordDAO = wordDAO;
        }

        @Override
        protected Void doInBackground(Word... words) {
            wordDAO.deleteWords(words);
            return null;
        }
    }

    void InsertWords(Word...words){
        new WordRepository.InsertAsyncTask(wordDAO).execute(words);
    }
    void UpdateWords(Word...words){
        new WordRepository.UpdateAsyncTask(wordDAO).execute(words);
    }
    void ClearWords(Word...words){
        new WordRepository.ClearAsyncTask(wordDAO).execute();
    }
    void DeleteWords(Word...words){
        new WordRepository.DeleteAsyncTask(wordDAO).execute(words);
    }
}
