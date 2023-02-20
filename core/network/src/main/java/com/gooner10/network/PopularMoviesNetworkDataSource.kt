package com.gooner10.network

import com.gooner10model.Movie


/*
* Interface representing network calls to the NIA backend
*/
interface PopularMoviesNetworkDataSource {
    suspend fun getPopularMovies(order: String = ""): List<Movie?>?
}