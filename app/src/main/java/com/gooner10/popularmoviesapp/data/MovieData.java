package com.gooner10.popularmoviesapp.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

/**
 * Movie Data Model for the pojo
 */
@Entity(tableName = "moviedata")
public class MovieData implements Parcelable {

    @PrimaryKey
    @NonNull
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

    public MovieData(String id, String movieTitle, String movieOverview, String moviePosterPath, String movieVoteAverage,
                     String movieVoteCount, String movieReleaseDate, String moviePopularity, String movieBackdropPath) {
        this.id = id;
        this.movieTitle = movieTitle;
        this.movieOverview = movieOverview;
        this.moviePosterPath = moviePosterPath;
        this.movieVoteAverage = movieVoteAverage;
        this.movieVoteCount = movieVoteCount;
        this.movieReleaseDate = movieReleaseDate;
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
