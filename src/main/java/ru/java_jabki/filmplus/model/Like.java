package ru.java_jabki.filmplus.model;

import java.util.Objects;

public class Like {
    private final Long userId;
    private final Integer filmId;

    @Override
    public boolean equals(Object obj){
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Like tmp = (Like) obj;
        return Objects.equals(tmp.getFilmId(), this.filmId) && Objects.equals(tmp.getUserId(), this.userId);
    }

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
