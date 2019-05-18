package com.gooner10.popularmoviesapp.moviemain

import com.gooner10.popularmoviesapp.data.MovieItem

/**
 * This specifies the contract between the Movie view and the Movie presenter.
 */
interface MovieContract {
    interface View {
        fun displayMovieList(movieDataList: List<MovieItem>)
    }
}
