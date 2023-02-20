package com.gooner10.moviehome

import com.gooner10.data.model.MovieItem


/**
 * This specifies the contract between the Movie view and the Movie presenter.
 */
interface MovieContract {
    interface View {
        fun displayMovieList(movieDataList: List<MovieItem>)
    }
}
