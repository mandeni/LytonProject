package com.example.lyton.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lyton.R;
import com.example.lyton.activity_fragment.ChatActivity;
import com.example.lyton.model.Users;

import java.util.List;


public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder>{

    private List<Users> users;
    public UsersAdapter(List<Users> users){
        this.users = users;
    }

    @NonNull
    @Override
    public UsersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(com.example.lyton.R.layout.users_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersAdapter.ViewHolder holder, int position) {
        holder.userName.setText(users.get(position).getName());
        holder.constraintLayout.setOnClickListener(v -> {
            String receiverId = users.get(position).getId();
            String receiverName = users.get(position).getName();
            Intent intent = new Intent(v.getContext(),ChatActivity.class);
            intent.putExtra("receiverId",receiverId);
            intent.putExtra("receiverName",receiverName);
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView userName;
        private ConstraintLayout constraintLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.user_name);
            constraintLayout = itemView.findViewById(R.id.user_item_layout);
        }
    }

}