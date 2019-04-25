package com.gooner10.popularmoviesapp.moviefavourite;

import com.gooner10.popularmoviesapp.data.MovieData;

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
