package com.example.lyton.viewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.lyton.model.Post;
import com.example.lyton.repository.PostRepository;

import java.util.List;

public class PostViewModel extends AndroidViewModel {
    private PostRepository repository;


    public PostViewModel(Application application){
        super(application);
        repository = PostRepository.getInstance(application);
    }

    public LiveData<List<Post>> getAllPosts(){
        return repository.getAllPosts();
    }

    public void insertPost(Post post){
        repository.insertPost(post);
    }

    public void deletePost(Post post){repository.deletePost(post);}
}