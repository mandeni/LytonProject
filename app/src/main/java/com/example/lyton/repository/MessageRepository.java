package com.example.lyton.repository;

import com.example.lyton.livedata.MessageLiveData;
import com.example.lyton.model.Messages;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MessageRepository {
    private static MessageRepository instance;
    private DatabaseReference databaseReference;
    private MessageLiveData message;

    public static synchronized MessageRepository getInstance() {
        if (instance == null){
            instance = new MessageRepository();
        }
        return instance;
    }

    public void init(String userId) {
        databaseReference = FirebaseDatabase.getInstance().getReference().child("users").child(userId);
        message = new MessageLiveData(databaseReference);
    }


    public MessageLiveData getMessage() {
        return message;
    }

}
