package com.example.lyton.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.lyton.livedata.UserLiveData;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;


public class UserRepository {

    private final UserLiveData currentUser;
    private final Application app;
    private static UserRepository instance;

    private UserRepository(Application app) {
        this.app = app;
        currentUser = new UserLiveData();
    }

    public static synchronized UserRepository getInstance(Application app) {
        if(instance == null)
            instance = new UserRepository(app);
        return instance;
    }

    public LiveData<FirebaseUser> getCurrentUser() {
        return currentUser;
    }

    public void signOut() {
        AuthUI.getInstance()
                .signOut(app.getApplicationContext());
    }

    public LiveData<List<UserLiveData>> getAllUsers() {

        return null;
    }
}
