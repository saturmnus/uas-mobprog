package com.salma.basjep.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.salma.basjep.models.User;

import java.util.List;

@Dao
public interface UserDao {

    // Insert a new user
    @Insert
    void insertUser(User user);

    // Retrieve user by username
    @Query("SELECT * FROM user_table WHERE username = :username LIMIT 1")
    User getUserByUsername(String username);

    // Optional: Retrieve all users (if needed)
    @Query("SELECT * FROM user_table")
    List<User> getAllUsers();

    @Query("SELECT * FROM user_table WHERE username = :username AND password = :password")
    User getUser(String username, String password);

}
