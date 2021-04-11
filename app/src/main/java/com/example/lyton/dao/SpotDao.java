package com.example.lyton.dao;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.lyton.model.Spot;

import java.util.ArrayList;
import java.util.List;

public class SpotDao {

    private MutableLiveData<List<Spot>> allSpot;
    private static SpotDao instance;


    private SpotDao(){
        allSpot = new MutableLiveData<>();
        List<Spot> newList = new ArrayList<>();
        allSpot.setValue(newList);
    }

    public static SpotDao getInstance() {
        if (instance == null){
            instance = new SpotDao();
        }

        return instance;
    }

    public LiveData<List<Spot>> getAllSpot() {
        return allSpot;
    }

    public void insertSpot(Spot spot) {
        List<Spot> currentList = allSpot.getValue();
        currentList.add(spot);
        allSpot.setValue(currentList);
    }
}
