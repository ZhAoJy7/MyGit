package com.zjy.design;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao //database access object
public interface UserDao {
    @Insert
    void insertUser(User user);

    @Update
    void updateUser(User user);

    @Delete
    void deleteWords(User user);

    @Query("SELECT * FROM User WHERE id= :id AND password= :password")
    User login(int id,String password);

}
