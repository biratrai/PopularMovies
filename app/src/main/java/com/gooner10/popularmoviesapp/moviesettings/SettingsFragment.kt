package com.gooner10.popularmoviesapp.moviesettings

import android.content.SharedPreferences
import android.content.SharedPreferences.OnSharedPreferenceChangeListener
import android.os.Bundle
import android.preference.ListPreference
import android.preference.PreferenceFragment
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gooner10.popularmoviesapp.R

/**
 * Settings Fragment that extends PreferenceFragment
 */
class SettingsFragment : PreferenceFragment(), OnSharedPreferenceChangeListener {
    private val mListPreference: ListPreference? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the default shared preference of the Preference Fragment
        PreferenceManager.setDefaultValues(activity, R.xml.pref_general, false)

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.pref_general)

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Get the default shared preference of the Preference Fragment
        //        PreferenceManager.setDefaultValues(getActivity(), R.xml.pref_general, false);
        //        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getActivity());
        //        String username = sharedPref.getString(getString(R.string.pref_sort_choice), "default value");
        //        mListPreference = (ListPreference) findPreference(getString(R.string.pref_sort_choice));
        //        mListPreference.setSummary(username);
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences, key: String) {
        //        if (key.equals(getString(R.string.pref_sort_choice))) {
        //            // Set summary to be the user-description for the selected value
        //            ListPreference sortChoicePref = (ListPreference) findPreference(key);
        //            sortChoicePref.setSummary(sharedPreferences.getString(key, "%s"));
        //        }
    }

    override fun onResume() {
        super.onResume()
        // Set up a listener whenever a key changes
        preferenceScreen.sharedPreferences.registerOnSharedPreferenceChangeListener(this)
    }

    override fun onPause() {
        super.onPause()
        // Set up a listener whenever a key changes
        preferenceScreen.sharedPreferences.unregisterOnSharedPreferenceChangeListener(this)
    }
}
