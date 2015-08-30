package com.gooner10.popularmoviesapp.Activity.domain.Model;

/**
 * Created by Gooner10 on 8/28/15.
 */
public class MovieData {


    public final String id;
    public final String mTitle;
    public final String mOverview;
    public final String mPosterPath;
    public final String mVoteAverage;
    public final String mVoteCount;
    public final String mReleaseDate;
    public final String mPopularity;
    public final String mBackdropPath;

    public MovieData(String id, String mTitle, String overview, String poster_path, String vote_average,
                     String vote_count, String release_date, String mPopularity, String mBackdropPath) {
        this.id = id;
        this.mTitle = mTitle;
        this.mOverview = overview;
        this.mPosterPath = poster_path;
        this.mVoteAverage = vote_average;
        this.mVoteCount = vote_count;
        this.mReleaseDate = release_date;
        this.mPopularity = mPopularity;
        this.mBackdropPath = mBackdropPath;
    }

    public String getId() {
        return id;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmOverview() {
        return mOverview;
    }

    public String getmPosterPath() {
        return mPosterPath;
    }

    public String getmVoteAverage() {
        return mVoteAverage;
    }

    public String getmVoteCount() {
        return mVoteCount;
    }

    public String getmReleaseDate() {
        return mReleaseDate;
    }
}
