package com.gooner10.popularmoviesapp.Activity.data;

import android.content.Context;

/**
 * Repository class to handle moviedata
 */

public class MovieRepositoryImpl implements IMovieRepository{
    private MovieDatabase movieDatabase;

    public static MovieDatabase getMovieDatabaseInstance(Context context) {
        return MovieDatabase.getInMemoryDatabase(context);
    }

    @Override
    public MovieData getMovie() {
        return null;
    }

    @Override
    public void insertOrUpdateMovieData(MovieData movieData) {

    }

    @Override
    public void deleteAllMovieData() {

    }
}
