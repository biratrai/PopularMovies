package com.gooner10.moviehome

import android.os.AsyncTask
import android.util.Log
import androidx.lifecycle.*
import com.gooner10.data.MovieItem
import com.gooner10.data.MovieResponse
import com.gooner10.network.RetrofitPopularMoviesNetworkApi
import com.gooner10.network.RetrofitServiceGenerator
//import hugo.weaving.DebugLog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * ViewModel class that gets the list of data fetched from back-end
 */

class MovieViewModel : ViewModel(), LifecycleObserver {
    private val movieDataList = MutableLiveData<List<MovieItem>>()

    //@DebugLog
    fun getMovieDataList(): LiveData<List<MovieItem>> {
        if (movieDataList.value == null) {
            AsyncTask.execute {
                Log.i(TAG, "fetching the movie: ")
                fetchMovieData()
            }
        }
        return movieDataList
    }

    //@DebugLog
    private fun fetchMovieData() {

        val call = RetrofitServiceGenerator.createService(RetrofitPopularMoviesNetworkApi::class.java)
                .fetchMoviesByPopularity("popularity.desc", "530c5cfd24953abae83df3e614c6d774")
        call.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                Log.i(TAG, "onResponse: $response")
                if (response.isSuccessful) {
                    Log.i(TAG, "onResponse: " + response.body()!!)
                    val movieResponse = response.body()
                    val movieList = movieResponse?.movieList
                    movieDataList.postValue(movieList as List<MovieItem>?)
                } else {
                    Log.e(TAG, "onResponse: " + response.code())
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ", t)
            }
        })
    }

    //@DebugLog
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    internal fun onCreate() {
        Log.i(TAG, " MovieViewModel onCreate: ")
    }

    //@DebugLog
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    internal fun onStart() {
        Log.i(TAG, "MovieViewModel onStart: ")
        getMovieDataList()
    }

    //@DebugLog
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    internal fun onStop() {
        Log.i(TAG, "MovieViewModel onStop: ")
    }

    //@DebugLog
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    internal fun onPause() {
        Log.i(TAG, "MovieViewModel onPause: ")
    }

    //@DebugLog
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    internal fun onResume() {
        Log.i(TAG, "MovieViewModel onResume: ")
    }

    companion object {
        val TAG = MovieViewModel::class.java.simpleName
    }
}
