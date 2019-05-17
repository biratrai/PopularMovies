package com.gooner10.popularmoviesapp.moviefavourite

import com.gooner10.popularmoviesapp.data.MovieItem

/**
 * Contract for the favorite fragment
 */

class MovieFavouriteContract {
    internal interface View {
        fun displayFavoriteMovie(movieDataList: List<MovieItem>)
    }

    internal interface Presenter {
        fun loadFavoriteMovieFromRepository()
    }
}
