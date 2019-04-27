package com.gooner10.popularmoviesapp.data;

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
    List<MovieItem> getAllFavoritMovie();

    @Insert
    void insertAll(MovieItem... movieData);

    @Delete
    void deleteMovies(MovieItem movieData);

    @Query("SELECT * FROM moviedata where id LIKE :movieId")
    boolean movieExists(String movieId);
}
