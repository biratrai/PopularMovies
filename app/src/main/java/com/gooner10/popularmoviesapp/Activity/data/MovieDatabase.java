package com.gooner10.popularmoviesapp.Activity.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Class to define Room database
 */
@Database(entities = {MovieData.class}, version = 1)
public abstract class MovieDatabase extends RoomDatabase {

}
