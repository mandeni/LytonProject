package com.example.lyton.model;

import android.net.Uri;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Post {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String text;
//    private Uri photoUri;

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Post(String text){
        this.text = text;
//        this.photoUri = photoUri;
    }

    public String getText() {
        return text;
    }

//    public Uri getPhotoUrl() {
//        return photoUri;
//    }

}
