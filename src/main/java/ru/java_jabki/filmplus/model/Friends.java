package ru.java_jabki.filmplus.model;

public class Friends {
    private final Long userId1;
    private final Long userId2;

    public Friends(final Long userId1, final Long userId2) {
        this.userId1 = userId1;
        this.userId2 = userId2;
    }

    public Long getUserId1() {
        return userId1;
    }

    public Long getUserId2() {
        return userId2;
    }
}
