package com.example.lyton.activity_fragment;


import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

import com.example.lyton.R;

import java.util.Locale;

public class SettingsFragment extends PreferenceFragmentCompat {


    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preference, rootKey);

        //      Send email for Feedback
        Preference feedback = findPreference("Feedback");
        feedback.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("*/*");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"feedbackLyton@mail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback for Lyton");
                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(intent);
                }
                return false;
            }
        });
    }
}
