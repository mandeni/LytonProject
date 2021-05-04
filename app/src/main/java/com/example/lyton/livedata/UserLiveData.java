package com.example.lyton.livedata;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.firebase.ui.auth.data.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class UserLiveData extends LiveData<FirebaseUser> {
    private final FirebaseAuth.AuthStateListener listener = firebaseAuth -> setValue(firebaseAuth.getCurrentUser());

//    private final ValueEventListener eventListener = new ValueEventListener() {
//        @Override
//        public void onDataChange(@NonNull DataSnapshot snapshot) {
//            FirebaseUser user = snapshot.getValue(FirebaseUser.class);
//            setValue(user);
//        }
//
//        @Override
//        public void onCancelled(@NonNull DatabaseError error) {
//        }
//    };
//    DatabaseReference databaseReference;
    @Override
    protected void onActive() {
        super.onActive();
        FirebaseAuth.getInstance().addAuthStateListener(listener);
    }

    @Override
    protected void onInactive() {
        super.onInactive();
        FirebaseAuth.getInstance().removeAuthStateListener(listener);
    }
}
