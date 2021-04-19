package com.example.lyton.dao;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.lyton.model.Post;
import com.example.lyton.model.Spot;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface PostDao {

    @Insert
    void insert(Post post);

    @Delete
    void delete(Post post);

    @Query("SELECT * FROM Post ORDER BY id DESC")
    LiveData<List<Post>> getAllPosts();

}
