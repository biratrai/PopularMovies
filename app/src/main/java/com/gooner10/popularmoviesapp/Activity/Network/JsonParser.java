package com.gooner10.popularmoviesapp.Activity.network;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.gooner10.popularmoviesapp.Activity.domain.Model.MovieData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Gooner10 on 8/28/15.
 */
public class JsonParser {
    private static MovieData mMovideData;
    ArrayList<MovieData> mMovieDataArrayList = new ArrayList<>();
    ArrayList<MovieData> mMovieArrayList = new ArrayList<>();
    public String LOG_TAG = "JsonParser";
    String id, title, overview, poster_path, vote_average, release_date, backdrop_path, vote_count, popularity;

    public ArrayList<MovieData> ParseJson() {
//        final String url = "http://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=530c5cfd24953abae83df3e614c6d774";
        final String url = "https://www.okcupid.com/matchSample.json";
        Log.d("MovieActivity", "JsonParser");
        RequestQueue requestQueue = VolleySingleton.getInstance().getRequestQueue();
        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("MovieActivity", "response " + response);
//               mMovieArrayList = parseJSONresponse(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsObjRequest);
        return mMovieArrayList;
    }

    private ArrayList<MovieData> parseJSONresponse(JSONObject response) {
        try {
            String jsonString = response.getString("results");

            JSONArray jsonArray = new JSONArray(jsonString);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                id = jsonObject.getString("id");
                title = jsonObject.getString("original_title");
                overview = jsonObject.getString("overview");
                release_date = jsonObject.getString("release_date");
                poster_path = jsonObject.getString("poster_path");
                backdrop_path = jsonObject.getString("backdrop_path");
                vote_average = jsonObject.getString("vote_average");
                vote_count = jsonObject.getString("vote_count");
                vote_average = jsonObject.getString("vote_average");
                popularity = jsonObject.getString("popularity");
                mMovideData = new MovieData(id, title, overview, poster_path, vote_average, vote_count,
                        release_date, popularity, backdrop_path);
                mMovieDataArrayList.add(mMovideData);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return mMovieDataArrayList;
    }
}
