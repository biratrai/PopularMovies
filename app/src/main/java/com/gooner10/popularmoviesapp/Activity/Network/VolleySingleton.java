package com.gooner10.popularmoviesapp.Activity.network;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.gooner10.popularmoviesapp.Activity.extras.MyApplication;

/**
 * Volley Singleton Class
 */
public class VolleySingleton {

    private static VolleySingleton sInstance;

    private static RequestQueue mRequestQueue;

    private VolleySingleton() {
        mRequestQueue = Volley.newRequestQueue(MyApplication.getAppContext());
    }

    public static VolleySingleton getInstance() {
        if (sInstance == null) {
            sInstance = new VolleySingleton();
        }

        return sInstance;
    }

    public RequestQueue getRequestQueue() {
        return mRequestQueue;
    }
}

