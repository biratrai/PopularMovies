package com.gooner10.popularmoviesapp

import android.app.Application

import com.facebook.stetho.Stetho

/**
 * Application class for the app
 */
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
    }

}
