package com.example.lyton.adapter;

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
import com.example.lyton.viewModel.PostViewModel;

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
        holder.postText.setText(posts.get(position).getText());
        Glide.with(holder.postPhoto)
                .load(posts.get(position).getPhotoUri())
                .override(300,400)
                .into(holder.postPhoto);
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
        private ImageView postPhoto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            postText = itemView.findViewById(R.id.post_text_view);
            postPhoto = itemView.findViewById(R.id.photo_post_image_view);
        }
    }

}
