package com.gooner10.popularmoviesapp.Activity.network;

/**
 * Rating Singleton Class
 */
public class Rating {
    private static Rating ourInstance;
    private static String averageRating = "7";

    public static Rating getInstance() {
        if (ourInstance == null)
            ourInstance = new Rating();
        return ourInstance;
    }

    private Rating() {
    }

    public String getAverageRating() {
        return averageRating;
    }

    public static void setAverageRating(String averageRating) {
        Rating.averageRating = averageRating;
    }
}
