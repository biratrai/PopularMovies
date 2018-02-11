package com.gooner10.popularmoviesapp.Activity.movielist;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gooner10.popularmoviesapp.R;

import static android.content.SharedPreferences.OnSharedPreferenceChangeListener;

/**
 * Settings Fragment that extends PreferenceFragment
 */
public class SettingsFragment extends PreferenceFragment implements OnSharedPreferenceChangeListener {
    private ListPreference mListPreference;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the default shared preference of the Preference Fragment
        PreferenceManager.setDefaultValues(getActivity(), R.xml.pref_general, false);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.pref_general);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Get the default shared preference of the Preference Fragment
//        PreferenceManager.setDefaultValues(getActivity(), R.xml.pref_general, false);
//        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getActivity());
//        String username = sharedPref.getString(getString(R.string.pref_sort_choice), "default value");
//        mListPreference = (ListPreference) findPreference(getString(R.string.pref_sort_choice));
//        mListPreference.setSummary(username);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
//        if (key.equals(getString(R.string.pref_sort_choice))) {
//            // Set summary to be the user-description for the selected value
//            ListPreference sortChoicePref = (ListPreference) findPreference(key);
//            sortChoicePref.setSummary(sharedPreferences.getString(key, "%s"));
//        }
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
