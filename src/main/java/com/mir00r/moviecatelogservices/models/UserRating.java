package com.mir00r.moviecatelogservices.models;

import java.util.List;

/**
 * @author mir00r on 1/4/22
 * @project IntelliJ IDEA
 */
public class UserRating {

    private String userId;
    private List<Rating> ratings;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
}
