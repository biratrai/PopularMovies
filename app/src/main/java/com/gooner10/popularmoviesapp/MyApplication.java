package com.gooner10.popularmoviesapp;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Application class for the app
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }

}
