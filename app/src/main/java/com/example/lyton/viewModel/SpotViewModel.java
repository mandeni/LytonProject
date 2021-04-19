package com.example.lyton.viewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.lyton.model.Spot;
import com.example.lyton.repository.SpotRepository;

import java.util.List;

public class SpotViewModel extends AndroidViewModel {

    private SpotRepository repository;


    public SpotViewModel(Application application){
        super(application);
        repository = SpotRepository.getInstance(application);
    }

    public LiveData<List<Spot>> getAllSpot(){
        return repository.getAllSpots();
    }

    public void insertSpot(Spot spot){
        repository.insertSpot(spot);
    }

}
