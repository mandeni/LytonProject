package com.example.lyton.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.lyton.dao.SpotDao;
import com.example.lyton.databases.SpotDatabase;
import com.example.lyton.model.Spot;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SpotRepository {

    private SpotDao spotDao;
    private  static SpotRepository instance;
    private ExecutorService executorService;

    private SpotRepository(Application application){
        SpotDatabase spotDatabase = SpotDatabase.getInstance(application);
        spotDao = spotDatabase.spotDao();
        executorService = Executors.newFixedThreadPool(2);
    }

    public static SpotRepository getInstance(Application application) {
        if (instance == null){
            instance = new SpotRepository(application);
        }

        return instance;
    }


    public void insertSpot(Spot spot) {
        executorService.execute(() -> spotDao.insert(spot));}

    public LiveData<List<Spot>> getAllSpots() {
        return spotDao.getAllSpots();
    }
}
