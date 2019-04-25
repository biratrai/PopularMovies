package com.gooner10.popularmoviesapp.moviemain;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.OnLifecycleEvent;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.util.Log;

import com.gooner10.popularmoviesapp.data.MovieData;
import com.gooner10.popularmoviesapp.data.MovieViewModel;

import java.util.List;

import hugo.weaving.DebugLog;

/**
 * Presenter for the Movie
 */
public class MovieListPresenter implements MovieContract.UserActionsListener, LifecycleObserver {
    public static final String TAG = MovieListPresenter.class.getSimpleName();
    private final MovieContract.View movieView;

    public MovieListPresenter(MovieContract.View movieView, LifecycleOwner lifecycleOwner) {
        this.movieView = movieView;
        lifecycleOwner.getLifecycle().addObserver(this);
    }

    @Override
    public void loadData() {
        MovieViewModel movieViewModel = ViewModelProviders.of((MovieFragment) movieView).get(MovieViewModel.class);
        Log.i(TAG, "loadData " + movieView);
        Log.i(TAG, "loadData getMovieDataList: " + movieViewModel.getMovieDataList());
        movieViewModel.getMovieDataList().observe((MovieFragment) movieView, new Observer<List<MovieData>>() {
            @Override
            @DebugLog
            public void onChanged(@Nullable List<MovieData> movieDataList) {
                movieView.displayMovieList(movieDataList);
            }
        });
    }

    @DebugLog
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate() {
        Log.i(TAG, " MovieViewModel onCreate: ");
    }

    @DebugLog
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void onStart() {
        Log.i(TAG, "MovieViewModel onStart: ");
        loadData();
    }

    @DebugLog
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void onStop() {
        Log.i(TAG, "MovieViewModel onStop: ");
    }

    @DebugLog
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void onPause() {
        Log.i(TAG, "MovieViewModel onPause: ");
    }

    @DebugLog
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void onResume() {
        Log.i(TAG, "MovieViewModel onResume: ");
    }

}
