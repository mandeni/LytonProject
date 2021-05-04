package com.example.lyton.activity_fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lyton.R;
import com.example.lyton.model.Conversation;
import com.google.firebase.database.DatabaseReference;

import java.util.List;


public class ChatFragment extends Fragment {


    private DatabaseReference databaseReference;
    private List<Conversation> conversations;

    public ChatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chat, container, false);


        //        RecyclerView setup
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_chat);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        //  Database setup
//        databaseReference = FirebaseDatabase.getInstance().getReference("Chats");
//        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if (snapshot.exists()) {
//                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
//                        Conversation conv = dataSnapshot.getValue(Conversation.class);
//                        conversations.add(conv);
//                    }
//                    convAdapter = new ConvAdapter(conversations);
//                    recyclerView.setAdapter(convAdapter);
//                }
//            }
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//            }
//        });
        return view;
    }
}