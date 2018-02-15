package com.gooner10.popularmoviesapp.Activity.moviesettings;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;

import com.gooner10.popularmoviesapp.Activity.moviemain.SettingsFragment;
import com.gooner10.popularmoviesapp.R;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Display the fragment as the main content
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();

//        setDefaultValues();

    }

    private void setDefaultValues() {
        PreferenceManager.setDefaultValues(this, R.xml.pref_general, false);
    }

}
