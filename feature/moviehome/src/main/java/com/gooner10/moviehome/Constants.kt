package com.gooner10.moviehome

/**
 * Constants for the project
 */
object Constants {
    val KEY_ID = "id"
    val KEY_TITLE = "mTitle"
    val KEY_OVERVIEW = "overview"
    val KEY_POSTER_PATH = "poster_path"
    val KEY_VOTE_AVERAGE = "vote_average"
    val KEY_VOTE_COUNT = "vote_count"
    val KEY_RELEASE_DATE = "release_date"
    val KEY_BACKDROP_PATH = "backdrop_path"

    var POSTER_PATH = "http://image.tmdb.org/t/p/w185/"
    var BASE_URL = "http://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key"
    var BACKDROP_PATH = "http://image.tmdb.org/t/p/w342/"

    var API_KEY = "530c5cfd24953abae83df3e614c6d774"
}
