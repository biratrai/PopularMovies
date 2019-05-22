package com.gooner10.popularmoviesapp.network

import com.gooner10.popularmoviesapp.data.MovieResponse

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PopularMoviesAPI {

    @GET("movie")
    fun fetchMoviesByPopularity(@Query("sort_by") order: String, @Query("api_key") key: String): Call<MovieResponse>
}
