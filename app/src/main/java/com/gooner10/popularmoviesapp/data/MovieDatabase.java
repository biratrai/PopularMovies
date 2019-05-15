package com.gooner10.popularmoviesapp.data;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

/**
 * Class to define Room database
 */
@Database(entities = {MovieItem.class}, version = 2)
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
                            .fallbackToDestructiveMigration()
                            // To simplify the codelab, allow queries on the main thread.
                            // Don't do this on a real app! See PersistenceBasicSample for an example.
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }
}
