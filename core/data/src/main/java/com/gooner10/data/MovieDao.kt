package com.gooner10.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

/**
 * MovieDao for Room
 */

@Dao
interface MovieDao {
    @get:Query("SELECT * FROM moviedata")
    val allFavoritMovie: List<com.gooner10.data.MovieItem>

    @Insert
    fun insertAll(vararg movieData: com.gooner10.data.MovieItem)

    @Delete
    fun deleteMovies(movieData: com.gooner10.data.MovieItem)

    @Query("SELECT * FROM moviedata where id LIKE :movieId")
    fun movieExists(movieId: Int): Boolean
}
