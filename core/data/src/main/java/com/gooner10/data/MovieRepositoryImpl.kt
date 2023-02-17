package com.gooner10.data

import android.content.Context
import android.util.Log

/**
 * Repository class to handle moviedata
 */

class MovieRepositoryImpl(private val movieDao: MovieDao) : IMovieRepository {

    override val movie: List<MovieItem>
        get() = movieDao.allFavoritMovie

    override fun insertOrUpdateMovieData(movieData: MovieItem?) {
        movieDao.insertAll(movieData!!)
    }

    override fun deleteAllMovieData(movieData: MovieItem?) {
        movieDao.deleteMovies(movieData!!)
    }

    override fun findMovieAlreadyIsFavorite(movieData: MovieItem?): Boolean {
        Log.d(TAG, "findMovieAlreadyIsFavorite: " + movieDao.movieExists(movieData!!.id))
        return movieDao.movieExists(movieData.id)
    }

    companion object {
        val TAG = MovieRepositoryImpl::class.java.simpleName
        @Volatile
        private var INSTANCE: MovieRepositoryImpl? = null

        fun getMovieDatabaseInstance(context: Context): MovieRepositoryImpl? {
            if (INSTANCE == null) {
                synchronized(MovieRepositoryImpl::class.java) {
                    if (INSTANCE == null) {
                        val movieDatabase = MovieDatabase.getInMemoryDatabase(context)
                        INSTANCE = MovieRepositoryImpl(movieDatabase.movieDao())
                    }
                }
            }
            return INSTANCE
        }
    }


}
