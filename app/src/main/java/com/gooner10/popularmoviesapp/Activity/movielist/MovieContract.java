package com.gooner10.popularmoviesapp.Activity.movielist;

import com.gooner10.popularmoviesapp.Activity.data.MovieData;

import java.util.ArrayList;

/**
 * This specifies the contract between the Movie view and the Movie presenter.
 */
public interface MovieContract {
    interface View {
        void displayMovieList(ArrayList<MovieData> movieDataList);
    }

    interface UserActionsListener {
        void loadData();
    }
}
