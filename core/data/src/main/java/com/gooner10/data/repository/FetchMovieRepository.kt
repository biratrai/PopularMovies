package com.gooner10.data.repository

import com.gooner10.data.model.MovieItem
import com.gooner10.network.PopularMoviesNetworkDataSource
import kotlinx.coroutines.flow.Flow

class FetchMovieRepository constructor(private val network: PopularMoviesNetworkDataSource) :
    MoviesRepository {
    override suspend fun getMovies(order: String): Flow<List<MovieItem>> {
//        return network.getPopularMovies(order = order)
        return TODO()
    }

}


interface MoviesRepository {
    /**
     * Gets the available topics as a stream
     */
    suspend fun getMovies(order: String = "popularity.desc"): Flow<List<MovieItem>>

}