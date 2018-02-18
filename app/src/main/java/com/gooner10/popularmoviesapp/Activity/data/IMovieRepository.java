package com.gooner10.popularmoviesapp.Activity.data;

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
    List<MovieData> getMovie();

    /**
     * Inserts the movie in the data source, or, if this is an existing movie, it updates it.
     *
     * @param movieData the movie to be inserted or updated.
     */
    void insertOrUpdateMovieData(MovieData movieData);

    /**
     * Deletes all movie from the data source.
     */
    void deleteAllMovieData();
}
