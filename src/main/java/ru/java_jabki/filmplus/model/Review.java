package ru.java_jabki.filmplus.model;

public class Review {
    private final Long userId;
    private final Integer filmId;
    private String review;

    public Review(Long userId, Integer filmId, String review) {
        this.userId = userId;
        this.filmId = filmId;
        this.review = review;
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
