package com.gooner10.data

/**
 * Access point for accessing movie data.
 */

interface IMovieRepository {


    /**
     * Gets all the movie from the data source.
     *
     * @return all the movie from the data source.
     */
    val movie: List<MovieItem>

    /**
     * Inserts the movie in the data source, or, if this is an existing movie, it updates it.
     *
     * @param movieData the movie to be inserted or updated.
     */
    fun insertOrUpdateMovieData(movieData: MovieItem?)

    /**
     * Deletes all movie from the data source.
     */
    fun deleteAllMovieData(movieData: MovieItem?)

    /**
     * Finds whether movie already exists in favorite database
     *
     * @param movieData MovieData to be searched
     * @return true if exits in database; false otherwise
     */
    fun findMovieAlreadyIsFavorite(movieData: MovieItem?): Boolean
}
