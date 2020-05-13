package com.zjy.design;

public class Picture {
    private String username;
    private int picId;

    public Picture(String username, int picId) {
        this.username = username;
        this.picId = picId;
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
}
