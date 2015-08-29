package com.gooner10.popularmoviesapp.Activity.Network;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;


/**
 * Created by Gooner10 on 8/28/15.
 */
public class JsonParser {
    final String url = "http://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=530c5cfd24953abae83df3e614c6d774";

    RequestQueue requestQueue = VolleySingleton.getInstance().getRequestQueue();
    JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, new Response.Listener<JSONArray>() {
        @Override
        public void onResponse(JSONArray response) {
            Log.d("MovieActivity",""+response);
        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

        }
    }
    );


}
