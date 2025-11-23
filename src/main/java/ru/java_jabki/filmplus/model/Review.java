package ru.java_jabki.filmplus.model;

import java.util.Objects;

public class Review {
    private final Long userId;
    private final Integer filmId;
    private String review;

    public Review(Long userId, Integer filmId, String review) {
        this.userId = userId;
        this.filmId = filmId;
        this.review = review;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Review tmp = (Review) obj;
        return Objects.equals(tmp.getFilmId(), this.filmId) && Objects.equals(tmp.getUserId(), this.userId);
    }

    public Integer getFilmId() {
        return this.filmId;
    }

    public Long getUserId() {
        return this.userId;
    }

    public String getReview() {
        return this.review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
