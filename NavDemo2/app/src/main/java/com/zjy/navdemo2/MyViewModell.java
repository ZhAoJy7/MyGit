package com.zjy.navdemo2;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModell extends ViewModel {
    private MutableLiveData<Integer> number;

    public MutableLiveData<Integer> getNumber() {
        if(number==null){
            number=new MutableLiveData<>();
            number.setValue(0);
        }
        return number;
    }

    public void add(int x){
        number.setValue(number.getValue()+x);
    }

    public void setNumber(MutableLiveData<Integer> number) {
        this.number = number;
    }
}
