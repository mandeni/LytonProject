package com.example.lyton.adapter;

import android.app.Application;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.lyton.R;
import com.example.lyton.model.Post;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private List<Post> posts;

    public PostAdapter(List<Post> posts) {
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
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.photoUri = Uri.parse(posts.get(position).getPhotoUri());
        holder.postText.setText(posts.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void updateData(List<Post> posts) {
        this.posts = posts;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView postText;
        private Uri photoUri;
        private ImageView postPhoto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            postText = itemView.findViewById(R.id.post_text_view);
//            userPhoto = itemView.findViewById(R.id.user_post_image_view);

            postPhoto = itemView.findViewById(R.id.photo_post_image_view);
            Glide.with(itemView.getContext())
                    .load(photoUri)
                    .override(150,150)
                    .into(postPhoto);
        }

    }

}
