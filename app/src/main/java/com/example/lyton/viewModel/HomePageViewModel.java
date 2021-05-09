package com.example.lyton.viewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.lyton.repository.UserRepository;
import com.google.firebase.auth.FirebaseUser;

public class HomePageViewModel extends AndroidViewModel {
    private final UserRepository userRepository;

    public HomePageViewModel(Application app){
        super(app);
        userRepository = UserRepository.getInstance(app);
    }

    public LiveData<FirebaseUser> getCurrentUser(){
        return userRepository.getCurrentUser();
    }

    public void signOut() {
        userRepository.signOut();
    }
}
