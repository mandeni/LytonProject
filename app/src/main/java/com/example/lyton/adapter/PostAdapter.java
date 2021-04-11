package com.example.lyton.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lyton.R;
import com.example.lyton.model.Post;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private ArrayList<Post> posts;

    public PostAdapter(ArrayList<Post> posts) {
        this.posts = posts;
    }

    @NonNull
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.post_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.ViewHolder holder, int position) {
//        holder.postPhoto.setI(posts.get(position).getUserName());
        holder.postText.setText(posts.get(position).getText());

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView postText;
        private ImageView postPhoto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            postText = itemView.findViewById(R.id.post_text_view);
//            userPhoto = itemView.findViewById(R.id.user_post_image_view);
            postPhoto = itemView.findViewById(R.id.photo_post_image_view);
//            itemView.setOnClickListener((View.OnClickListener)this);
        }

    }

}
