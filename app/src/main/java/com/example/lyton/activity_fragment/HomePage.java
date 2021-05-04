package com.example.lyton.activity_fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lyton.R;
import com.example.lyton.adapter.ViewPagerAdapter;
import com.example.lyton.viewModel.HomePageViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

import static com.google.android.material.tabs.TabLayout.*;


public class HomePage extends AppCompatActivity{

    private FloatingActionButton fabPost;
    private FloatingActionButton fabChat;
    private FloatingActionButton fabSpot;
    private TextView newPostTextView, newSpotTextView, newChatTextView;
    private final Float translationYAxis = 100f;
    private Boolean isFABMenuOpen = false;
    private final OvershootInterpolator interpolator = new OvershootInterpolator();

    private ViewPager viewPager;

//    DrawerLayout
    private DrawerLayout drawerLayout;

    private HomePageViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(HomePageViewModel.class);
        checkIfSignedIn();
        setContentView(R.layout.home_page);

        //      Toolbar setting
        Toolbar toolBar = findViewById(R.id.toolbar_homePage);
        setSupportActionBar(toolBar);


        //        Navigation View and Drawer Layout
        NavigationView navigationView = findViewById(R.id.drawer_home_page);
        drawerLayout = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolBar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            Intent intent = new Intent();
            if (id == R.id.item_my_wishing_trip){
                intent.setClass(HomePage.this,MyWishingList.class);
            }

            startActivity(intent);
            drawerLayout.closeDrawer(GravityCompat.START);

            return true;
        });


        //        FAB
        showFABMenu();

        //    Tabs
        TabLayout tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.viewPager);
        final ViewPagerAdapter adapter = new ViewPagerAdapter(this,
                getSupportFragmentManager(),
                tabLayout.getTabCount());
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

    private void checkIfSignedIn() {
        viewModel.getCurrentUser().observe(this, user -> {
            if (user != null) {
                String message = "Welcome " + user.getDisplayName();
                Toast.makeText(this,message,Toast.LENGTH_SHORT).show();

                //  Create user in Firebase
                FirebaseDatabase firebaseDatabase;
                firebaseDatabase = FirebaseDatabase.getInstance();
                DatabaseReference reference = firebaseDatabase.getReference();

                String userId = user.getUid();
                String email = user.getEmail();
                String userName = user.getDisplayName();
                HashMap<String,Object> hashMap = new HashMap<>();
                hashMap.put("name", userName);
                hashMap.put("id",userId);
                hashMap.put("email",email);

                reference.child("Users").child(userId).setValue(hashMap);

            } else
                startLoginActivity();
        });
    }

    private void startLoginActivity() {
        startActivity(new Intent(this, SignInActivity.class));
        finish();
    }

    public void signOut() {
        viewModel.signOut();
    }

    //  Menu inflater for home page menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home_page,menu);
        return super.onCreateOptionsMenu(menu);
    }

    //  FAB function
    private void showFABMenu() {
        //    FAB
        FloatingActionButton fab = findViewById(R.id.fab);
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

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.setting_menu_home_page){
            Intent intent = new Intent(this, SettingActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.log_out_menu_home_page){
            signOut();
            startLoginActivity();
        }
        return super.onOptionsItemSelected(item);
    }
}
