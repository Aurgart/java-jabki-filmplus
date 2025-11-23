package ru.java_jabki.filmplus.model;

public enum Genre {
    COMEDY(1), DRAMA(2), ACTION(3), THRILLER(4), HORROR(5), ROMANTIC(6);

    private final int id;

    Genre(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}
