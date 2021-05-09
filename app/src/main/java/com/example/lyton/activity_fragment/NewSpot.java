package com.example.lyton.activity_fragment;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.lyton.R;
import com.example.lyton.adapter.SpotAdapter;
import com.example.lyton.model.Spot;
import com.example.lyton.viewModel.SpotViewModel;

import java.util.ArrayList;
import java.util.List;

public class NewSpot extends AppCompatActivity {

    private EditText name, country, city, address, description;
    private SpotViewModel spotViewModel;
    private ImageView photo;
    private Uri spotPhotoUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_spot);

        //      Toolbar setting
        Toolbar toolBar = findViewById(R.id.toolbar_new_spot);
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //      View Model
        name = findViewById(R.id.name_spot);
        country = findViewById(R.id.country_spot);
        city = findViewById(R.id.city_spot);
        address = findViewById(R.id.address_spot);
        description = findViewById(R.id.description_spot);
        photo = findViewById(R.id.select_image_view);

        spotViewModel = new ViewModelProvider(this).get(SpotViewModel.class);
    }

    public void addSpotPhoto(View view){
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent,2);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            assert data != null;
            spotPhotoUri = data.getData();
            if (spotPhotoUri != null) {
                photo.setImageURI(spotPhotoUri);
            }
        }
    }

    public void saveSpot(View view){
        spotViewModel.insertSpot(new Spot(name.getText().toString(), country.getText().toString(),
                city.getText().toString(), address.getText().toString(),
                description.getText().toString(), spotPhotoUri.toString()));
        finish();
        Toast.makeText(this,"Add new spot successfully", Toast.LENGTH_SHORT).show();
    }
}
