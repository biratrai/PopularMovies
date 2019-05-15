package com.gooner10.popularmoviesapp.moviemain;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;
import android.os.AsyncTask;
import android.util.Log;

import com.gooner10.popularmoviesapp.data.MovieItem;
import com.gooner10.popularmoviesapp.data.MovieResponse;
import com.gooner10.popularmoviesapp.network.PopularMoviesAPI;
import com.gooner10.popularmoviesapp.network.RetrofitServiceGenerator;

import java.util.List;

import hugo.weaving.DebugLog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * ViewModel class that gets the list of data fetched from back-end
 */

public class MovieViewModel extends ViewModel implements LifecycleObserver {
    public static final String TAG = MovieViewModel.class.getSimpleName();
    private MutableLiveData<List<MovieItem>> movieDataList = new MutableLiveData<>();

    @DebugLog
    public LiveData<List<MovieItem>> getMovieDataList() {
        Log.i(TAG, "getMovieDataList: " + movieDataList.getValue());
        if (movieDataList.getValue() == null) {
            AsyncTask.execute(new Runnable() {
                @Override
                @DebugLog
                public void run() {
                    Log.i(TAG, "fetching the movie: ");
                    fetchMovieData();
                }
            });
        }
        return movieDataList;
    }

    @DebugLog
    private void fetchMovieData() {

        Call<MovieResponse> call = RetrofitServiceGenerator.createService(PopularMoviesAPI.class)
                .fetchMoviesByPopularity("popularity.desc", "530c5cfd24953abae83df3e614c6d774");
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                Log.i(TAG, "onResponse: " + response);
                if (response.isSuccessful()) {
                    Log.i(TAG, "onResponse: " + response.body());
                    movieDataList.postValue(response.body().getMovieList());
                } else {
                    Log.e(TAG, "onResponse: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: ", t);
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
        getMovieDataList();
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
