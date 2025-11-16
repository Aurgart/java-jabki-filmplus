package ru.java_jabki.filmplus.model;

public enum Genre {
    Comedy(1), Drama(2), Action(3), Thriller(4), Horror(5), Romantic(6);

    private final int id;

    Genre(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}
