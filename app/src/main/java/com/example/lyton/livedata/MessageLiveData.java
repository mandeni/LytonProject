package com.example.lyton.livedata;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.example.lyton.model.Messages;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class MessageLiveData extends LiveData<Messages> {
    private final ValueEventListener listener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            Messages message = snapshot.getValue(Messages.class);
            setValue(message);
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {
        }
    };
    DatabaseReference databaseReference;

    public MessageLiveData(DatabaseReference databaseReference) {
        this.databaseReference = databaseReference;
    }

    @Override
    protected void onActive() {
        super.onActive();
        databaseReference.addValueEventListener(listener);
    }

    @Override
    protected void onInactive() {
        super.onInactive();
        databaseReference.removeEventListener(listener);
    }
}
