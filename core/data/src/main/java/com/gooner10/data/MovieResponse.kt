package com.gooner10.data

import com.google.gson.annotations.SerializedName

data class MovieResponse(

    @field:SerializedName("page")
        val page: Int? = null,

    @field:SerializedName("total_pages")
        val totalPages: Int? = null,

    @field:SerializedName("results")
        val movieList: List<com.gooner10.data.MovieItem?>? = null,

    @field:SerializedName("total_results")
        val totalResults: Int? = null
)