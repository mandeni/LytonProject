package com.example.lyton.activity_fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.lyton.R;
import com.example.lyton.adapter.SpotAdapter;
import com.example.lyton.model.Spot;
import com.example.lyton.viewModel.SpotViewModel;

import java.util.ArrayList;
import java.util.List;

public class MyWishingList extends AppCompatActivity {

    private SpotAdapter spotAdapter;
    private SpotViewModel spotViewModel;


    private List<Spot> spots = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_wishing_list);

        //      Toolbar setting
        Toolbar toolBar = findViewById(R.id.toolbar_my_wishing_list);
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //        RecyclerView setup
        RecyclerView recyclerView = findViewById(R.id.recycler_view_my_wishing_list);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        spotAdapter = new SpotAdapter(spots);
        recyclerView.setAdapter(spotAdapter);

        //      View Model
        spotViewModel = new ViewModelProvider(this).get(SpotViewModel.class);
        spotViewModel.getAllSpot().observe(this, spots -> spotAdapter.updateData(spots));
    }


}