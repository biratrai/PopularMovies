package com.gooner10.popularmoviesapp.moviefavourite

import com.gooner10.data.MovieItem

/**
 * Contract for the favorite fragment
 */

class MovieFavouriteContract {
    interface View {
        fun displayFavoriteMovie(movieDataList: List<com.gooner10.data.MovieItem>)
    }

    internal interface Presenter {
        fun loadFavoriteMovieFromRepository()
    }
}
