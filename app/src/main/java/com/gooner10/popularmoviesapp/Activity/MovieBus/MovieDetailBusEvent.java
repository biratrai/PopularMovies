package com.gooner10.popularmoviesapp.Activity.movieBus;

import android.os.Bundle;

/**
 * Created by Gooner10 on 8/30/15.
 */
public class MovieDetailBusEvent {
    public final Bundle bundle;
//    public final String name;

//    public MovieDetailBusEvent(String name) {
//        this.name = name;
//    }

    public MovieDetailBusEvent(Bundle bundle) {
        this.bundle = bundle;
    }


}
