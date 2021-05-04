package com.example.lyton.activity_fragment;

import android.os.Bundle;

import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

import com.example.lyton.R;

public class SettingsFragment extends PreferenceFragmentCompat{

    public  static final int RESULT_CODE_THEME_UPDATED =1;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preference, rootKey);

    }


}