package ru.java_jabki.filmplus.model;

import java.time.LocalDate;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Film {

    private int id;
    private final String name;
    private final LocalDate releaseDate;
    private final Long duration;
    private String description;
    private Set<Genre> genres;

    public Film(int id,String name, String description, LocalDate releaseDate, Long duration, Set<Genre> genres) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.genres = genres;
    }

    public String getName() {
        return this.name;
    }

    public void setId(int id){
        this.id = id;
    }

    public LocalDate getReleaseDate() {
        return this.releaseDate;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return this.id;
    }

    public Long getDuration() {
        return this.duration;
    }

    public Set<Genre> getGenres() {
        return this.genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }
}
