package com.zjy.design;

import android.graphics.Bitmap;

public class Picture {
    private String username;
    private int picId;
    private Bitmap bitmap;

    public Picture(String username, int picId) {
        this.username = username;
        this.picId = picId;
    }

    public Picture(String username, Bitmap bitmap) {
        this.username = username;
        this.bitmap=bitmap;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPicId() {
        return picId;
    }

    public void setPicId(int picId) {
        this.picId = picId;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
