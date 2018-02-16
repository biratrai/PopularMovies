package com.gooner10.popularmoviesapp.Activity.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * MovieDao for Room
 */

@Dao
public interface MovieDao {
    @Query("SELECT * FROM moviedata")
    List<MovieData> getAllFavoritMovie();

    @Insert
    void insertAll(MovieData... movieData);

    @Delete
    void deleteMovies(MovieData movieData);
}
