package com.gooner10.popularmoviesapp.Activity.moviefavourite;

import com.gooner10.popularmoviesapp.Activity.data.MovieData;

import java.util.List;

/**
 * Contract for the favorite fragment
 */

public class MovieFavouriteContract {
    interface View {
        void displayFavoriteMovie(List<MovieData> movieDataList);
    }

    interface Presenter {
        void loadFavoriteMovieFromRepository();
    }
}
