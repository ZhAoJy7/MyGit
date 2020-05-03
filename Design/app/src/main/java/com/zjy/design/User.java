package com.zjy.design;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "userName")
    private String userName;

    @ColumnInfo(name = "password")
    private String password;

    @ColumnInfo(name = "emailAddress")
    private String emailAddress;

    @ColumnInfo(name = "isAdmin")
    private boolean isAdmin;

    @ColumnInfo(name = "isBanned")
    private boolean isBanned;


    public User(String userName, String password, String emailAddress, boolean isAdmin, boolean isBanned) {
        this.userName = userName;
        this.password = password;
        this.emailAddress = emailAddress;
        this.isAdmin = isAdmin;
        this.isBanned = isBanned;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isBanned() {
        return isBanned;
    }

    public void setBanned(boolean banned) {
        isBanned = banned;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
