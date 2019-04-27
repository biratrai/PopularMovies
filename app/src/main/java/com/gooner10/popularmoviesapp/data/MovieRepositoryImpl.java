package com.gooner10.popularmoviesapp.data;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

/**
 * Repository class to handle moviedata
 */

public class MovieRepositoryImpl implements IMovieRepository {
    public static final String TAG = MovieRepositoryImpl.class.getSimpleName();
    private static volatile MovieRepositoryImpl INSTANCE;
    private MovieDao movieDao;

    public MovieRepositoryImpl(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    public static MovieRepositoryImpl getMovieDatabaseInstance(@NonNull Context context) {
        if (INSTANCE == null) {
            synchronized (MovieRepositoryImpl.class) {
                if (INSTANCE == null) {
                    MovieDatabase movieDatabase = MovieDatabase.getInMemoryDatabase(context);
                    INSTANCE = new MovieRepositoryImpl(movieDatabase.movieDao());
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public List<MovieItem> getMovie() {
        return movieDao.getAllFavoritMovie();
    }

    @Override
    public void insertOrUpdateMovieData(MovieItem movieData) {
        movieDao.insertAll(movieData);
    }

    @Override
    public void deleteAllMovieData(MovieItem movieData) {
        movieDao.deleteMovies(movieData);
    }

    @Override
    public boolean findMovieAlreadyIsFavorite(MovieItem movieData) {
        Log.d(TAG, "findMovieAlreadyIsFavorite: " + movieDao.movieExists(String.valueOf(movieData.getId())));
        return movieDao.movieExists(String.valueOf(movieData.getId()));
    }


}
