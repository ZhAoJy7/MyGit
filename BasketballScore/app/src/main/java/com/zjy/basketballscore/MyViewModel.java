package com.zjy.basketballscore;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private MutableLiveData<Integer> scoreA;
    private MutableLiveData<Integer> scoreB;
    int tempA,tempB;

    public MutableLiveData<Integer> getScoreA() {
        if(scoreA==null){
            scoreA=new MutableLiveData<>();
            scoreA.setValue(0);
        }
        return scoreA;
    }
    public MutableLiveData<Integer> getScoreB() {
        if(scoreB==null){
           scoreB=new MutableLiveData<>();
           scoreB.setValue(0);
        }
        return scoreB;
    }

    public void setScoreA(MutableLiveData<Integer> scoreA) {
        this.scoreA = scoreA;
    }
    public void setScoreB(MutableLiveData<Integer> scoreB) {
        this.scoreB = scoreB;
    }

    public void addA(int num){
        tempA=scoreA.getValue();
        tempB=scoreB.getValue();
        scoreA.setValue(scoreA.getValue()+num);
    }
    public void addB(int num){
        tempA=scoreA.getValue();
        tempB=scoreB.getValue();
        scoreB.setValue(scoreB.getValue()+num);
    }

    public void Refresh(){
        tempA=scoreA.getValue();
        tempB=scoreB.getValue();
        this.scoreA.setValue(0);
        this.scoreB.setValue(0);
    }

    public void Cancel(){
        scoreA.setValue(tempA);
        scoreB.setValue(tempB);
    }
}
