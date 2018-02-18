package com.gooner10.popularmoviesapp.Activity.data;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.List;

/**
 * Repository class to handle moviedata
 */

public class MovieRepositoryImpl implements IMovieRepository {
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
    public List<MovieData> getMovie() {
        return movieDao.getAllFavoritMovie();
    }

    @Override
    public void insertOrUpdateMovieData(MovieData movieData) {
        movieDao.insertAll(movieData);
    }

    @Override
    public void deleteAllMovieData() {

    }
}
