package com.gooner10.popularmoviesapp.Activity.data;

/**
 * Created by Gooner10 on 2/15/18.
 */

public class MovieRepository {
    private MovieDatabase movieDatabase;

    public static MovieDatabase getMovieDatabaseInstance(){
        MovieDatabase.getInMemoryDatabase(this.getApplication());
    }
}
