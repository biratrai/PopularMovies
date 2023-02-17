package com.gooner10.network

import com.gooner10.data.MovieItem


/*
* Interface representing network calls to the NIA backend
*/
interface PopularMoviesNetworkDataSource {
    suspend fun getPopularMovies(order: String = ""): List<MovieItem>
}