package com.gooner10.popularmoviesapp.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;
import android.util.Log;

import com.gooner10.popularmoviesapp.network.PopularMoviesAPI;
import com.gooner10.popularmoviesapp.network.RetrofitServiceGenerator;

import java.util.List;

import hugo.weaving.DebugLog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * ViewModel class that store the data fetched from back-end
 */

public class MovieViewModel extends ViewModel {
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
}
