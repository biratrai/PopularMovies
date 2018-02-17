package com.gooner10.popularmoviesapp.Activity;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;

/**
 * Application class for the app
 */
public class MyApplication extends Application {
    private static MyApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        Stetho.initializeWithDefaults(this);
    }

    public static MyApplication getInstance() {
        return sInstance;
    }

    public static Context getAppContext() {
        return sInstance.getApplicationContext();
    }
}
