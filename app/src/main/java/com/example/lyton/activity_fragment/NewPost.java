package com.example.lyton.activity_fragment;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lyton.R;
import com.example.lyton.adapter.SpotAdapter;
import com.example.lyton.model.Post;
import com.example.lyton.model.Spot;
import com.example.lyton.viewModel.HomePageViewModel;
import com.example.lyton.viewModel.PostViewModel;
import com.example.lyton.viewModel.SpotViewModel;

import java.util.ArrayList;
import java.util.List;

public class NewPost extends AppCompatActivity {

    private ImageView imageView;
    private EditText editText;
    private Uri photoUri;

    //View model variable declared
    private PostViewModel postViewModel;
    private SpotViewModel spotViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);

//              Toolbar setting
        Toolbar toolBar = findViewById(R.id.toolbar_new_post);
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        Views initiate
        imageView = findViewById(R.id.new_post_image_view);
        editText = findViewById(R.id.new_post_edit_text);

//      Setting up View model
        postViewModel = new ViewModelProvider(this).get(PostViewModel.class);
        spotViewModel = new ViewModelProvider(this).get(SpotViewModel.class);

    }

    public void addPhoto(View view){
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent,1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            assert data != null;
            photoUri = data.getData();
            if (photoUri != null) {
                imageView.setImageURI(photoUri);
            }
        }
    }

    public void save(View view){
        postViewModel.insertPost(new Post(editText.getText().toString(), photoUri.toString()));
        finish();
    }

}