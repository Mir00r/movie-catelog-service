package com.mir00r.moviecatelogservices.models;

/**
 * @author mir00r on 1/4/22
 * @project IntelliJ IDEA
 */
public class Rating {
    private String movieId;
    private int rating;

    public Rating() {
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
