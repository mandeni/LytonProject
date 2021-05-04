package com.example.lyton.activity_fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.lyton.R;
import com.example.lyton.adapter.MessageAdapter;
import com.example.lyton.model.Conversation;
import com.example.lyton.model.Users;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    private MessageAdapter messageAdapter;
    private RecyclerView recyclerView;
    private List<Conversation> conversations = new ArrayList<>();

    private Intent intent;

    private Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        //      Toolbar setting
        Toolbar toolBar = findViewById(R.id.toolbar_chats);
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //        RecyclerView setup
        recyclerView = findViewById(R.id.recycler_view_messages);
        recyclerView.hasFixedSize();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);

        //        Receiver Id
        intent = getIntent();
        final String receiverId = intent.getStringExtra("receiverId");
        final String receiverName = intent.getStringExtra("receiverName");

        //      Sender Information (me)
        final String senderId = FirebaseAuth.getInstance().getCurrentUser().getUid().toString();
        final String senderName = FirebaseAuth.getInstance().getCurrentUser().getDisplayName().
                toString();


        //      Send button on click
        send = findViewById(R.id.button_send);
        send.setOnClickListener(v -> {
            EditText messageView = findViewById(R.id.message_edit_text);
            String message = messageView.getText().toString();

            if (!message.equals("")) {
                sendButton(senderId, senderName, receiverId, receiverName,message);
                messageView.setText("");
            }
        });

        DatabaseReference databaseReferenceUser = FirebaseDatabase.getInstance().
                getReference("Users").child(receiverId);
        databaseReferenceUser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Users user= snapshot.getValue(Users.class);
                String receiverName = user.getName();
                String receiverId = user.getId();

                toolBar.setTitle(receiverName);

                receiveMessage(senderId,receiverId);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    private void sendButton(String senderId, String senderName,String receiverId,
                            String receiverName, String message) {

        DatabaseReference messageReference = FirebaseDatabase.getInstance().getReference();

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("senderId", senderId);
        hashMap.put("receiverId",receiverId);
        hashMap.put("senderName",senderName);
        hashMap.put("receiverName",receiverName);
        hashMap.put("message",message);

        messageReference.child("Conversations").push().setValue(hashMap);
    }

    private void receiveMessage(String senderId, String receiverId){
        DatabaseReference databaseReferenceConversation = FirebaseDatabase.getInstance().
                getReference("Conversations");
        databaseReferenceConversation.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                        Conversation c = dataSnapshot.getValue(Conversation.class);
                        if (c.getReceiverId().equals(receiverId) && c.getSenderId().equals(senderId)
                            || c.getSenderId().equals(receiverId) && c.getReceiverId().
                                equals(senderId)){
                            conversations.add(c);
                    }
                        messageAdapter = new MessageAdapter(conversations);
                        recyclerView.setAdapter(messageAdapter);
                }}
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}