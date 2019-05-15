package com.gooner10.popularmoviesapp.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

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
    boolean movieExists(int movieId);
}
