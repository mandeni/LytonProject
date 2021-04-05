package com.example.lyton.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.lyton.PostFragment;
import com.example.lyton.R;

public class NewPost extends AppCompatActivity {

    private ImageView imageView;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);

        //      Toolbar setting
        Toolbar newPostToolBar = findViewById(R.id.toolbar_new_post);
        setSupportActionBar(newPostToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imageView = findViewById(R.id.new_post_image_view);
        editText = findViewById(R.id.new_post_edit_text);
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
            Uri photoUri = data.getData();
            if (photoUri != null) {
                imageView.setImageURI(photoUri);
            }
        }
    }

    public void save(View view){

        Intent saveIntent = new Intent(this, HomePage.class);
        Bundle bundle = new Bundle();
        bundle.putString("Post text", editText.getText().toString());
        PostFragment  postFragment= new PostFragment();
        postFragment.setArguments(bundle);
        startActivity(saveIntent,bundle);
//        imageView.buildDrawingCache();
//        Bitmap image= imageView.getDrawingCache();
//
//        Bundle extras = new Bundle();
//        extras.putParcelable("imageBitmap", image);
//
//        Intent saveIntent = new Intent(this, PostFragment.class);
//        saveIntent.putExtra("Post text",editText.getText().toString());
//        saveIntent.putExtras(extras);
//        startActivity(saveIntent);
    }
}