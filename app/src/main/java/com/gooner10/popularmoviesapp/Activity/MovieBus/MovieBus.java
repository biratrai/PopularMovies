package com.gooner10.popularmoviesapp.Activity.MovieBus;

import com.squareup.otto.Bus;

/**
 * Created by Gooner10 on 8/30/15.
 */
public class MovieBus {
    private static Bus instance = null;

    private MovieBus()
    {
        instance = new Bus();
    }

    public static Bus getInstance()
    {
        if(instance == null)
        {
            instance = new Bus();
        }
        return instance;
    }
}
