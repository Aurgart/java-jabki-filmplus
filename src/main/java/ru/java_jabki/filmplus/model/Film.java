package ru.java_jabki.filmplus.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@Builder
public class Film {

    private int id;
    private final String name;
    private final LocalDate releaseDate;
    private final Long duration;
    private String description;
    private Set<Genre> genres;
}
