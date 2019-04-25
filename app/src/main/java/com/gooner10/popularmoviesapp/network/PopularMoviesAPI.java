package com.gooner10.popularmoviesapp.network;

import com.gooner10.popularmoviesapp.data.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PopularMoviesAPI {

    @GET("movie")
    Call<MovieResponse> fetchMoviesByPopularity(@Query("sort_by") String order
            , @Query("api_key") String key);
}
