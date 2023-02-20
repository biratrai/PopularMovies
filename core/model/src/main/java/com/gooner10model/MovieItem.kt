package com.gooner10model

data class Movie(
    var id: Int,
    var overview: String,
    var originalLanguage: String,
    var originalTitle: String,
    var video: Boolean,
    var title: String,
    var posterPath: String,
    var backdropPath: String,
    var releaseDate: String,
    var voteAverage: Double,
    var popularity: Double,
    var adult: Boolean,
    var voteCount: Int
)