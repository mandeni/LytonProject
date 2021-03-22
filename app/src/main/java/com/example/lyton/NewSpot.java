package com.example.lyton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class NewSpot extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_spot);

        //      Toolbar setting
        Toolbar homePageToolBar = findViewById(R.id.toolbar_new_spot);
        setSupportActionBar(homePageToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}