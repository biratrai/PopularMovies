package com.gooner10.popularmoviesapp.moviefavourite;

import com.gooner10.popularmoviesapp.data.MovieItem;

import java.util.List;

/**
 * Contract for the favorite fragment
 */

public class MovieFavouriteContract {
    interface View {
        void displayFavoriteMovie(List<MovieItem> movieDataList);
    }

    interface Presenter {
        void loadFavoriteMovieFromRepository();
    }
}
