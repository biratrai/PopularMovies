package com.gooner10.network.model

import com.google.gson.annotations.SerializedName
import com.gooner10model.Movie

data class NetWorkMovieResponse(

    @field:SerializedName("page")
        val page: Int? = null,

    @field:SerializedName("total_pages")
        val totalPages: Int? = null,

    @field:SerializedName("results")
        val movieList: List<Movie?>? = null,

    @field:SerializedName("total_results")
        val totalResults: Int? = null
)

data class NetworkMovies(

    @field:SerializedName("page")
    val page: Int? = null,

    @field:SerializedName("total_pages")
    val totalPages: Int? = null,

    @field:SerializedName("results")
    val movieList: List<Movie?>? = null,

    @field:SerializedName("total_results")
    val totalResults: Int? = null
)