package com.gooner10.favorite

import com.gooner10.data.model.MovieItem

/**
 * Contract for the favorite fragment
 */

class MovieFavouriteContract {
    interface View {
        fun displayFavoriteMovie(movieDataList: List<MovieItem>)
    }

    internal interface Presenter {
        fun loadFavoriteMovieFromRepository()
    }
}
