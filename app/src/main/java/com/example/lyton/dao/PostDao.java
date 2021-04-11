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
//    private MutableLiveData<List<Post>> allPost;
//    private static PostDao instance;
//
//
//    private PostDao(){
//        allPost= new MutableLiveData<>();
//        List<Post> newList = new ArrayList<>();
//        allPost.setValue(newList);
//    }
//
//    public static PostDao getInstance() {
//        if (instance == null){
//            instance = new PostDao();
//        }
//
//        return instance;
//    }
//
//    public LiveData<List<Post>> getAllPost() {
//        return allPost;
//    }
//
//
//    public void insertPost(Post post) {
//        List<Post> currentList = allPost.getValue();
//        currentList.add(post);
//        allPost.setValue(currentList);
//    }
}
