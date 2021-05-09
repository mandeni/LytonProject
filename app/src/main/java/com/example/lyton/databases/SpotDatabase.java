package com.example.lyton.databases;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.lyton.dao.SpotDao;
import com.example.lyton.model.Spot;


@Database(entities = {Spot.class}, version = 1,exportSchema = false)
public abstract class SpotDatabase extends RoomDatabase {
    private static SpotDatabase instance;
    public abstract SpotDao spotDao();

    public static synchronized SpotDatabase getInstance(Context context) {
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    SpotDatabase.class,"spot_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}

