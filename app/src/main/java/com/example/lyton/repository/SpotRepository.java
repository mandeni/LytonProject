package com.example.lyton.repository;

import androidx.lifecycle.LiveData;

import com.example.lyton.model.Spot;
import com.example.lyton.dao.SpotDao;

import java.util.List;

public class SpotRepository {

    private SpotDao spotDao;
    private  static SpotRepository instance;

    private SpotRepository(){
        spotDao = SpotDao.getInstance();
    }

    public static SpotRepository getInstance() {
        if (instance == null){
            instance = new SpotRepository();
        }

        return instance;
    }

    public LiveData<List<Spot>> getAllSpot() {
        return spotDao.getAllSpot();
    }

    public void insertSpot(Spot spot) {
        spotDao.insertSpot(spot);
    }
}
