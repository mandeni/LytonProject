package com.example.lyton.databases;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.lyton.dao.PostDao;
import com.example.lyton.model.Post;

@Database(entities = {Post.class}, version = 1,exportSchema = false)
public abstract class PostDatabase extends RoomDatabase {

    private static PostDatabase instance;
    public abstract PostDao postDao();

    public static synchronized PostDatabase getInstance(Context context) {
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    PostDatabase.class,"post_database")
                    .fallbackToDestructiveMigration()
                    .build();
            }
        return instance;
        }
}


