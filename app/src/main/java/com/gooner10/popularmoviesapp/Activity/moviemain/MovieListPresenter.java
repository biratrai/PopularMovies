package com.gooner10.popularmoviesapp.Activity.moviemain;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.gooner10.popularmoviesapp.Activity.data.MovieData;
import com.gooner10.popularmoviesapp.Activity.network.VolleySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Presenter for the Movie
 */
public class MovieListPresenter implements MovieContract.UserActionsListener {
    public static final String TAG = MovieListPresenter.class.getSimpleName();
    private final String LOG_TAG = MovieListPresenter.class.getSimpleName();
    private final ArrayList<MovieData> mMovieDataArrayList = new ArrayList<>();
    private final MovieContract.View movieView;

    public MovieListPresenter(MovieContract.View movieView) {
        this.movieView = movieView;
    }

    @Override
    public void loadData() {

        JsonParser();
        Log.i(LOG_TAG, "loadData");
    }

    private void JsonParser() {
        final String url = "http://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=530c5cfd24953abae83df3e614c6d774";
        Log.d("MovieActivity", "JsonParser");
        RequestQueue requestQueue = VolleySingleton.getInstance().getRequestQueue();
        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("MovieActivity", "" + response);
                parseJSONresponse(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        requestQueue.add(jsObjRequest);
    }

    private void parseJSONresponse(JSONObject response) {
        try {
            String jsonString = response.getString("results");

            JSONArray jsonArray = new JSONArray(jsonString);
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
                mMovieDataArrayList.add(movieData);
            }

        } catch (JSONException e) {
            Log.e(TAG, "parseJSONresponse:", e);
        }
        movieView.displayMovieList(mMovieDataArrayList);
    }
}
