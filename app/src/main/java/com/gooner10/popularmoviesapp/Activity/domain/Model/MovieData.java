package com.gooner10.popularmoviesapp.Activity.domain.Model;

/**
 * Created by Gooner10 on 8/28/15.
 */
public class MovieData {


    public final long id;
    public final String mTitle;
    public final String mOverview;
    public final String mPosterPath;
    public final double mVoteAverage;
    public final long mVoteCount;
    public final String mReleaseDate;

    public MovieData(long id, String mTitle, String overview, String poster_path, double vote_average, long vote_count, String release_date) {
        this.id = id;
        this.mTitle = mTitle;
        this.mOverview = overview;
        this.mPosterPath = poster_path;
        this.mVoteAverage = vote_average;
        this.mVoteCount = vote_count;
        this.mReleaseDate = release_date;
    }

    public long getId() {
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

    public double getmVoteAverage() {
        return mVoteAverage;
    }

    public long getmVoteCount() {
        return mVoteCount;
    }

    public String getmReleaseDate() {
        return mReleaseDate;
    }
}
