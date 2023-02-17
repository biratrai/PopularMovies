package com.gooner10.settings

import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity


class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Display the fragment as the main content
        fragmentManager.beginTransaction()
                .replace(android.R.id.content, SettingsFragment())
                .commit()

        //        setDefaultValues();

    }

    private fun setDefaultValues() {
        PreferenceManager.setDefaultValues(this, R.xml.pref_general, false)
    }

}
