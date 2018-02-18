package com.gooner10.popularmoviesapp.Activity.moviefavourite;

import android.content.Context;

import com.gooner10.popularmoviesapp.Activity.data.MovieRepositoryImpl;

/**
 * Presenter for the FavoriteFragment
 */

public class MovieFavoritePresenter implements MovieFavouriteContract.Presenter {
    private final MovieFavouriteContract.View view;
    private MovieRepositoryImpl movieRepository;
    private Context context;

    public MovieFavoritePresenter(Context context, MovieFavouriteContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void loadFavoriteMovieFromRepository() {
        movieRepository = MovieRepositoryImpl.getMovieDatabaseInstance(context);
        view.displayFavoriteMovie(movieRepository.getMovie());
    }
}
