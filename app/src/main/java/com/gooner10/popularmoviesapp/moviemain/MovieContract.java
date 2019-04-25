package com.gooner10.popularmoviesapp.moviemain;

import com.gooner10.popularmoviesapp.data.MovieData;

import java.util.List;

/**
 * This specifies the contract between the Movie view and the Movie presenter.
 */
public interface MovieContract {
    interface View {
        void displayMovieList(List<MovieData> movieDataList);
    }

    interface UserActionsListener {
        void loadData();
    }
}