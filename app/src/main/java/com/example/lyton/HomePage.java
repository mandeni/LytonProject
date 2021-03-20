package com.example.lyton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;


public class HomePage extends AppCompatActivity {

    FloatingActionButton fab, fabPost, fabChat, fabSpot;
    TextView newPostTextView, newSpotTextView, newChatTextView;
    Float translationYAxis = 100f;
    Boolean isFABMenuOpen = false;

    OvershootInterpolator interpolator = new OvershootInterpolator();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        Toolbar homePageToolBar = (Toolbar) findViewById(R.id.toolbar_homePage);
        setSupportActionBar(homePageToolBar);

        showFABMenu();

    }


    private void showFABMenu() {
        fab = findViewById(R.id.fab);
        fabPost = findViewById(R.id.fab_post);
        fabChat = findViewById(R.id.fab_chat);
        fabSpot = findViewById(R.id.fab_spot);

        newChatTextView = (TextView) findViewById(R.id.new_chat_text_view) ;
        newPostTextView = (TextView) findViewById(R.id.new_post_text_view) ;
        newSpotTextView = (TextView) findViewById(R.id.new_spot_text_view) ;

        fabPost.setAlpha(0f);
        fabSpot.setAlpha(0f);
        fabChat.setAlpha(0f);

        newChatTextView.setAlpha(0f);
        newPostTextView.setAlpha(0f);
        newSpotTextView.setAlpha(0f);

        fabPost.setTranslationY(translationYAxis);
        fabSpot.setTranslationY(translationYAxis);
        fabChat.setTranslationY(translationYAxis);

        newSpotTextView.setTranslationY(translationYAxis);
        newPostTextView.setTranslationY(translationYAxis);
        newPostTextView.setTranslationY(translationYAxis);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFABMenuOpen){
                    closeFABMenu();
                }else {
                    openFABMenu();
                }
            }
        });

        fabPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomePage.this,"New Post is clicked", Toast.LENGTH_SHORT).show();
            }
        });

        fabSpot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomePage.this,"New Spot is clicked",Toast.LENGTH_SHORT).show();
            }
        });

        fabChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomePage.this,"New Chat is clicked",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void openFABMenu() {

        isFABMenuOpen = true;

        fabSpot.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();
        fabChat.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();
        fabPost.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();

        newSpotTextView.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();
        newChatTextView.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();
        newPostTextView.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();
    }

    private void closeFABMenu() {
        isFABMenuOpen = false;

        fabSpot.animate().translationY(translationYAxis).alpha(0f).setInterpolator(interpolator).setDuration(300).start();
        fabChat.animate().translationY(translationYAxis).alpha(0f).setInterpolator(interpolator).setDuration(300).start();
        fabPost.animate().translationY(translationYAxis).alpha(0f).setInterpolator(interpolator).setDuration(300).start();

        newSpotTextView.animate().translationY(translationYAxis).alpha(0f).setInterpolator(interpolator).setDuration(300).start();
        newChatTextView.animate().translationY(translationYAxis).alpha(0f).setInterpolator(interpolator).setDuration(300).start();
        newPostTextView.animate().translationY(translationYAxis).alpha(0f).setInterpolator(interpolator).setDuration(300).start();

    }
}
