package com.gooner10.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.gooner10.data.model.MovieItem

/**
 * MovieDao for Room
 */

@Dao
interface MovieDao {
    @get:Query("SELECT * FROM moviedata")
    val allFavoritMovie: List<MovieItem>

    @Insert
    fun insertAll(vararg movieData: MovieItem)

    @Delete
    fun deleteMovies(movieData: MovieItem)

    @Query("SELECT * FROM moviedata where id LIKE :movieId")
    fun movieExists(movieId: Int): Boolean
}
