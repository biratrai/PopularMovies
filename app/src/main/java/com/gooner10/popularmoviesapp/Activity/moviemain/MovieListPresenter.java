package com.gooner10.popularmoviesapp.Activity.moviemain;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.util.Log;

import com.gooner10.popularmoviesapp.Activity.data.MovieData;
import com.gooner10.popularmoviesapp.Activity.data.MovieViewModel;

import java.util.List;

import hugo.weaving.DebugLog;

/**
 * Presenter for the Movie
 */
public class MovieListPresenter implements MovieContract.UserActionsListener {
    public static final String TAG = MovieListPresenter.class.getSimpleName();
    private final MovieContract.View movieView;

    public MovieListPresenter(MovieContract.View movieView) {
        this.movieView = movieView;
    }

    @Override
    public void loadData() {
        MovieViewModel movieViewModel = ViewModelProviders.of((MovieFragment) movieView).get(MovieViewModel.class);
        Log.i(TAG, "loadData " + movieView);
        Log.i(TAG, "loadData getMovieDataList: "+ movieViewModel.getMovieDataList());
        movieViewModel.getMovieDataList().observe((MovieFragment) movieView, new Observer<List<MovieData>>() {
            @Override
            @DebugLog
            public void onChanged(@Nullable List<MovieData> movieDataList) {
                movieView.displayMovieList(movieDataList);
            }
        });

    }

}
