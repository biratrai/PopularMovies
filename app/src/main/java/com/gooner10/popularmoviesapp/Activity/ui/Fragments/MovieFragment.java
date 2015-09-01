package com.gooner10.popularmoviesapp.Activity.ui.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.gooner10.popularmoviesapp.Activity.Network.VolleySingleton;
import com.gooner10.popularmoviesapp.Activity.domain.Model.MovieData;
import com.gooner10.popularmoviesapp.Activity.ui.Adapter.MovieFragmentAdapter;
import com.gooner10.popularmoviesapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.Bind;


public class MovieFragment extends Fragment{
    private static ArrayList<MovieData> mPopularDataArrayList;
    private static MovieData mMovideData;
    ArrayList<MovieData> mMovieDataArrayList = new ArrayList<>();
    public String LOG_TAG = "MovieFragment";
    String id, title, overview, poster_path, vote_average, release_date, backdrop_path, vote_count, popularity;
    private MovieFragmentAdapter mMovieAdapter;

    @Bind(R.id.recyclerViewMovie)
    RecyclerView mMovieRecyclerView;

    public MovieFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Register to the bus
//        MovieBus.getInstance().register(this);

        JsonParser();

        View view = inflater.inflate(R.layout.fragment_movie, container, false);
        mMovieRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewMovie);
        mMovieRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mMovieAdapter = new MovieFragmentAdapter(getActivity(), mMovieDataArrayList);
        mMovieRecyclerView.setAdapter(mMovieAdapter);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        EventBus.getDefault().registerSticky(this);

    }


    public void JsonParser() {
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
            Log.i(LOG_TAG, "Array" + jsonArray.getClass());
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
        Log.d(LOG_TAG, "" + mMovieDataArrayList);
//      EventBus.getDefault().postSticky(mMovieDataArrayList);

    }

}
