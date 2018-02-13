package com.gooner10.popularmoviesapp.Activity.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Movie Data Model for the pojo
 */
@Entity
public class MovieData implements Parcelable {

    @PrimaryKey
    private final String id;

    @ColumnInfo
    private final String movieTitle;

    @ColumnInfo
    public final String movieOverview;

    @ColumnInfo
    private final String moviePosterPath;

    @ColumnInfo
    private final String movieVoteAverage;

    @ColumnInfo
    private final String movieVoteCount;

    @ColumnInfo
    private final String movieReleaseDate;

    @ColumnInfo
    private final String moviePopularity;

    @ColumnInfo
    public final String movieBackdropPath;

    public MovieData(String id, String movieTitle, String overview, String posterPath, String voteAverage,
                     String voteCount, String releaseDate, String moviePopularity, String movieBackdropPath) {
        this.id = id;
        this.movieTitle = movieTitle;
        this.movieOverview = overview;
        this.moviePosterPath = posterPath;
        this.movieVoteAverage = voteAverage;
        this.movieVoteCount = voteCount;
        this.movieReleaseDate = releaseDate;
        this.moviePopularity = moviePopularity;
        this.movieBackdropPath = movieBackdropPath;
    }

    public String getId() {
        return id;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getMovieOverview() {
        return movieOverview;
    }

    public String getMoviePosterPath() {
        return moviePosterPath;
    }

    public String getMovieVoteAverage() {
        return movieVoteAverage;
    }

    public String getMovieVoteCount() {
        return movieVoteCount;
    }

    public String getMovieReleaseDate() {
        return movieReleaseDate;
    }

    public String getMoviePopularity() {
        return moviePopularity;
    }

    public String getMovieBackdropPath() {
        return movieBackdropPath;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(movieTitle);
        parcel.writeString(movieOverview);
        parcel.writeString(moviePosterPath);
        parcel.writeString(movieVoteAverage);
        parcel.writeString(movieVoteCount);
        parcel.writeString(movieReleaseDate);
        parcel.writeString(moviePopularity);
        parcel.writeString(movieBackdropPath);
    }

    private MovieData(Parcel input) {
        id = input.readString();
        movieTitle = input.readString();
        movieOverview = input.readString();
        moviePosterPath = input.readString();
        movieVoteAverage = input.readString();
        movieVoteCount = input.readString();
        movieReleaseDate = input.readString();
        moviePopularity = input.readString();
        movieBackdropPath = input.readString();
    }

    public static final Parcelable.Creator<MovieData> CREATOR
            = new Parcelable.Creator<MovieData>() {
        public MovieData createFromParcel(Parcel in) {
            return new MovieData(in);
        }

        public MovieData[] newArray(int size) {
            return new MovieData[size];
        }
    };

}
