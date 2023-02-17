package com.gooner10.moviehome


/**
 * This specifies the contract between the Movie view and the Movie presenter.
 */
interface MovieContract {
    interface View {
        fun displayMovieList(movieDataList: List<com.gooner10.data.MovieItem>)
    }
}
