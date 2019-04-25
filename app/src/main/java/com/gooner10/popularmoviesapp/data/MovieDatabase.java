package com.gooner10.popularmoviesapp.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Class to define Room database
 */
@Database(entities = {MovieData.class}, version = 1)
public abstract class MovieDatabase extends RoomDatabase {
    private static final String MOVIE_DATABASE_NAME = "movie.db";
    private static MovieDatabase INSTANCE;

    public abstract MovieDao movieDao();

    public static MovieDatabase getInMemoryDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(),
                            MovieDatabase.class,
                            MOVIE_DATABASE_NAME)
                            // To simplify the codelab, allow queries on the main thread.
                            // Don't do this on a real app! See PersistenceBasicSample for an example.
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }
}