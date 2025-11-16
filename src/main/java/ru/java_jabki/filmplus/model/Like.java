package ru.java_jabki.filmplus.model;

public class Like {
    private final Long userId;
    private final Integer filmId;

    public Like(Long userId, Integer filmId) {
        this.userId = userId;
        this.filmId = filmId;
    }

    public Integer getFilmId() {
        return this.filmId;
    }

    public Long getUserId() {
        return this.userId;
    }
}
