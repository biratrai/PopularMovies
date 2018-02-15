package com.gooner10.popularmoviesapp.Activity;

import android.app.Application;
import android.content.Context;

/**
 * Created by Gooner10 on 8/28/15.
 */
public class MyApplication extends Application {
    private static MyApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

    public static MyApplication getInstance() {
        return sInstance;
    }

    public static Context getAppContext() {
        return sInstance.getApplicationContext();
    }
}
