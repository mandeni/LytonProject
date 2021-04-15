package com.example.lyton;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.lyton.activity_fragment.ChatFragment;
import com.example.lyton.activity_fragment.PostFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    int totalTabs;
    Context context;

    public ViewPagerAdapter(@NonNull Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        this.context = context;
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        if (position == 0) return new ChatFragment();
        else if (position == 1) return new PostFragment();
        else return null;
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
