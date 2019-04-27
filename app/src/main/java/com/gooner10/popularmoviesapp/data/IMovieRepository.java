package com.gooner10.popularmoviesapp.data;

import java.util.List;

/**
 * Access point for accessing movie data.
 */

public interface IMovieRepository {


    /**
     * Gets all the movie from the data source.
     *
     * @return all the movie from the data source.
     */
    List<MovieItem> getMovie();

    /**
     * Inserts the movie in the data source, or, if this is an existing movie, it updates it.
     *
     * @param movieData the movie to be inserted or updated.
     */
    void insertOrUpdateMovieData(MovieItem movieData);

    /**
     * Deletes all movie from the data source.
     */
    void deleteAllMovieData(MovieItem movieData);

    /**
     * Finds whether movie already exists in favorite database
     *
     * @param movieData MovieData to be searched
     * @return true if exits in database; false otherwise
     */
    boolean findMovieAlreadyIsFavorite(MovieItem movieData);
}
