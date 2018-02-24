package com.gooner10.popularmoviesapp.Activity.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.gooner10.popularmoviesapp.Activity.network.VolleySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import hugo.weaving.DebugLog;

/**
 * ViewModel class that store the data fetched from back-end
 */

public class MovieViewModel extends ViewModel {
    public static final String TAG = MovieViewModel.class.getSimpleName();
    private MutableLiveData<List<MovieData>> movieDataList = new MutableLiveData<>();

    @DebugLog
    public LiveData<List<MovieData>> getMovieDataList() {
        if (movieDataList == null) {
            AsyncTask.execute(new Runnable() {
                @Override
                public void run() {
                    fetchMovieData();
                }
            });
        }
        return movieDataList;
    }

    @DebugLog
    private void fetchMovieData() {

        final String url = "http://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=530c5cfd24953abae83df3e614c6d774";
        Log.d(TAG, "JsonParser");
        RequestQueue requestQueue = VolleySingleton.getInstance().getRequestQueue();
        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, "" + response);
                parseJSONresponse(response);
            }
        }, new Response.ErrorListener() {
            @Override
            @DebugLog
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "onErrorResponse: ", error);
            }
        });
        requestQueue.add(jsObjRequest);
    }


    private void parseJSONresponse(JSONObject response) {
        try {
            String jsonString = response.getString("results");

            JSONArray jsonArray = new JSONArray(jsonString);
            List<MovieData> movieList = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                String id = jsonObject.getString("id");
                String title = jsonObject.getString("original_title");
                String overview = jsonObject.getString("overview");
                String release_date = jsonObject.getString("release_date");
                String poster_path = jsonObject.getString("poster_path");
                String backdrop_path = jsonObject.getString("backdrop_path");
                String vote_average = jsonObject.getString("vote_average");
                String vote_count = jsonObject.getString("vote_count");
                String popularity = jsonObject.getString("popularity");
                MovieData movieData
                        = new MovieData(id, title, overview, poster_path, vote_average, vote_count,
                        release_date, popularity, backdrop_path);
                movieList.add(movieData);
            }
            movieDataList.setValue(movieList);
            movieDataList.postValue(movieList);
            Log.d(TAG, "parseJSONresponse: " + movieList);
        } catch (JSONException e) {
            Log.e(TAG, "parseJSONresponse:", e);
        }
    }
}
