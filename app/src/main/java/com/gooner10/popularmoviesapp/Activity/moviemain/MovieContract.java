package com.gooner10.popularmoviesapp.Activity.moviemain;

import com.gooner10.popularmoviesapp.Activity.data.MovieData;

import java.util.ArrayList;
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
