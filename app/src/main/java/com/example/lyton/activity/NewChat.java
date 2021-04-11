package com.example.lyton.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.SearchView;

import com.example.lyton.R;

public class NewChat extends AppCompatActivity {

    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_chat);

        //      Toolbar setting
        Toolbar newChatToolBar = findViewById(R.id.toolbar_new_chat);
        setSupportActionBar(newChatToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

}