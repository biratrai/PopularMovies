package com.gooner10.popularmoviesapp.Activity.data;

import android.content.Context;

/**
 * Repository class to handle moviedata
 */

public class MovieRepository {
    private MovieDatabase movieDatabase;

    public static MovieDatabase getMovieDatabaseInstance(Context context) {
        return MovieDatabase.getInMemoryDatabase(context);
    }
}
