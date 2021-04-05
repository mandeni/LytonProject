package com.example.lyton.activity;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;

import com.example.lyton.R;
import com.example.lyton.ViewPagerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import static com.google.android.material.tabs.TabLayout.*;


public class HomePage extends AppCompatActivity {

//    Setting of FAB
    FloatingActionButton fab, fabPost, fabChat, fabSpot;
    TextView newPostTextView, newSpotTextView, newChatTextView;
    Float translationYAxis = 100f;
    Boolean isFABMenuOpen = false;

    OvershootInterpolator interpolator = new OvershootInterpolator();

//    Setting of tabs
    TabLayout tabLayout;
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

//      Toolbar setting
        Toolbar homePageToolBar = findViewById(R.id.toolbar_homePage);
        setSupportActionBar(homePageToolBar);

//        Navigation View and Drawer Layout
        NavigationView navigationView = findViewById(R.id.drawer_home_page);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, homePageToolBar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

//        navigationView.setNavigationItemSelectedListener(this);

//        FAB
        showFABMenu();

//        Tabs
        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.viewPager);
        final ViewPagerAdapter adapter = new ViewPagerAdapter(this, getSupportFragmentManager(),tabLayout.getTabCount());

        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }


        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home_page,menu);
        return super.onCreateOptionsMenu(menu);
    }

    //  FAB function
    private void showFABMenu() {
        fab = findViewById(R.id.fab);
        fabPost = findViewById(R.id.fab_post);
        fabChat = findViewById(R.id.fab_chat);
        fabSpot = findViewById(R.id.fab_spot);

        newChatTextView = findViewById(R.id.new_chat_text_view);
        newPostTextView = findViewById(R.id.new_post_text_view);
        newSpotTextView = findViewById(R.id.new_spot_text_view);

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

        fab.setOnClickListener(v -> {
            if (isFABMenuOpen){
                closeFABMenu();
            }else {
                openFABMenu();
            }
        });

//        onClick for post fab
        fabPost.setOnClickListener(v -> {
            Context context = getApplicationContext();
            Intent intentPost = new Intent(context, NewPost.class);
            startActivity(intentPost);
        });

//      onClick for spot fab
        fabSpot.setOnClickListener(v -> {
            Context context = getApplicationContext();
            Intent intentPost = new Intent(context, NewSpot.class);
            startActivity(intentPost);
        });

//        onClick for chat fab
        fabChat.setOnClickListener(v -> {
            Context context = getApplicationContext();
            Intent intentPost = new Intent(context, NewChat.class);
            startActivity(intentPost);
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
