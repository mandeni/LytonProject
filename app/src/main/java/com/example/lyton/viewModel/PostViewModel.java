package com.example.lyton.viewModel;

import android.app.Application;
import android.widget.EditText;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.lyton.model.Post;
import com.example.lyton.model.Spot;
import com.example.lyton.repository.PostRepository;
import com.example.lyton.repository.SpotRepository;

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