package com.gooner10.popularmoviesapp.moviefavourite

import android.content.Context

import com.gooner10.data.MovieRepositoryImpl

/**
 * Presenter for the FavoriteFragment
 */

class MovieFavoritePresenter(private val context: Context, private val view: MovieFavouriteContract.View) : MovieFavouriteContract.Presenter {
    private var movieRepository: com.gooner10.data.MovieRepositoryImpl? = null

    override fun loadFavoriteMovieFromRepository() {
        movieRepository = com.gooner10.data.MovieRepositoryImpl.getMovieDatabaseInstance(context)
        view.displayFavoriteMovie(movieRepository!!.movie)
    }
}
