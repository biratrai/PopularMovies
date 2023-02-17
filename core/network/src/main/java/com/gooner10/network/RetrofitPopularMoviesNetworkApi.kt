package com.gooner10.network

import com.gooner10.data.MovieResponse
import com.gooner10.data.Movies

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitPopularMoviesNetworkApi {

    @GET("movie")
    fun fetchMoviesByPopularity(@Query("sort_by") order: String, @Query("api_key") key: String): Call<MovieResponse>

    @GET("movie")
    fun getMoviesByPopularity(@Query("sort_by") order: String, @Query("api_key") key: String): NetworkResponse<Movies>
}

//private const val PopularMoviesBaseUrl = BuildConfig.BACKEND_URL

/**
 * Wrapper for data provided from the [PopularMoviesBaseUrl]
 */
//@Serializable
data class NetworkResponse<T>(
    val data: T
)
