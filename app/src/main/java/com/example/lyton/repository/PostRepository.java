package com.example.lyton.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.lyton.dao.PostDao;
import com.example.lyton.dao.SpotDao;
import com.example.lyton.databases.PostDatabase;
import com.example.lyton.model.Post;
import com.example.lyton.model.Spot;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class PostRepository {

    private PostDao postDao;
    private static PostRepository instance;
    private ExecutorService executorService;

    private PostRepository(Application application){
        PostDatabase postDatabase = PostDatabase.getInstance(application);
        postDao = postDatabase.postDao();
        executorService = Executors.newFixedThreadPool(2);
    }

    public static PostRepository getInstance(Application application) {
        if (instance == null){
            instance = new PostRepository(application);
        }

        return instance;
    }


    public void insertPost(Post post) {
        executorService.execute(() -> postDao.insert(post));}

    public LiveData<List<Post>> getAllPosts() {
        return postDao.getAllPosts();
    }
}
