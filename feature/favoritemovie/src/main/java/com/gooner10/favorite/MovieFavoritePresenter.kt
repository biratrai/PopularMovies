package com.gooner10.favorite

import android.content.Context

import com.gooner10.data.repository.MovieRepositoryImpl

/**
 * Presenter for the FavoriteFragment
 */

class MovieFavoritePresenter(private val context: Context, private val view: MovieFavouriteContract.View) :
    MovieFavouriteContract.Presenter {
    private var movieRepository: MovieRepositoryImpl? = null

    override fun loadFavoriteMovieFromRepository() {
        movieRepository = MovieRepositoryImpl.getMovieDatabaseInstance(context)
        view.displayFavoriteMovie(movieRepository!!.movie)
    }
}
