package com.example.lyton.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.lyton.R;
import com.example.lyton.model.Spot;
import com.example.lyton.viewModel.SpotViewModel;

import java.util.List;

public class NewSpot extends AppCompatActivity {

    private EditText name, country, city, address, description;
    private SpotViewModel spotViewModel;
    private ImageView imageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_spot);

        //      Toolbar setting
        Toolbar newSpotToolBar = findViewById(R.id.toolbar_new_spot);
        setSupportActionBar(newSpotToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //      View Model
        name = findViewById(R.id.name_spot);
        country = findViewById(R.id.country_spot);
        city = findViewById(R.id.city_spot);
        address = findViewById(R.id.address_spot);
        description = findViewById(R.id.description_spot);
        imageView = findViewById(R.id.select_image_view);

        spotViewModel = new ViewModelProvider(this).get(SpotViewModel.class);
        spotViewModel.getAllSpot().observe(this, spots -> {

        });
    }

    public void saveSpot(View view){
        if (imageView == null) {
            spotViewModel.insertSpot(new Spot(name.getText().toString(), country.getText().toString(),
                    city.getText().toString(), address.getText().toString(), description.getText().toString()));
        }

        this.finish();
        Toast.makeText(this,"Add new spot successfully", Toast.LENGTH_SHORT).show();
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
            Uri photoUri = data.getData();
            if (photoUri != null) {
             imageView.setImageURI(photoUri);
            }
        }
    }
}
