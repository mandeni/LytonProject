package com.example.lyton.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.lyton.model.Spot;
import com.example.lyton.repository.SpotRepository;

import java.util.List;

public class SpotViewModel extends ViewModel {

    private SpotRepository repository;


    public SpotViewModel(){
        repository = SpotRepository.getInstance();
    }

    public LiveData<List<Spot>> getAllSpot(){
        return repository.getAllSpot();
    }

    public void insertSpot(Spot spot){
        repository.insertSpot(spot);
    }
}
