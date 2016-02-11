package com.gooner10.popularmoviesapp.Activity.ui.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

import com.gooner10.popularmoviesapp.R;

import static android.content.SharedPreferences.*;

/**
 * Settings Fragment that extends PreferenceFragment
 */
public class SettingsFragment extends PreferenceFragment implements OnSharedPreferenceChangeListener {
    private ListPreference mListPreference;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_general);

        // Get the default shared preference of the Preference Fragment
        PreferenceManager.setDefaultValues(getActivity(), R.xml.pref_general, false);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String username = sharedPref.getString(getString(R.string.pref_sort_choice), "default value");
//        Log.d("TAG", "pref_choice_popularity " + username);
        mListPreference = (ListPreference) findPreference(getString(R.string.pref_sort_choice));
        mListPreference.setSummary(username);

    }


    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (key.equals(getString(R.string.pref_sort_choice))) {
            // Set summary to be the user-description for the selected value
            ListPreference sortChoicePref = (ListPreference) findPreference(key);
            sortChoicePref.setSummary(sharedPreferences.getString(key, ""));
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        // Set up a listener whenever a key changes
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        // Set up a listener whenever a key changes
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }
}
