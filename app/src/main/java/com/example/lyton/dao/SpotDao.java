package com.example.lyton.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.lyton.model.Spot;

import java.util.List;

@Dao
public interface SpotDao {

    @Insert
    void insert(Spot spot);

    @Delete
    void delete(Spot spot);

    @Query("SELECT * FROM Spot ORDER BY id DESC")
    LiveData<List<Spot>> getAllSpots();
}
