package com.example.lyton.model;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Post {
    @PrimaryKey()
    private int id;
    private String text;
//    private ImageView photo;

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
//        this.photo = photo;
    }

    public String getText() {
        return text;
    }

//    public ImageView getPhoto() {
//        return photo;
//    }

}
