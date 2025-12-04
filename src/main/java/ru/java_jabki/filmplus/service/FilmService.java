package ru.java_jabki.filmplus.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.java_jabki.filmplus.exceptions.FilmException;
import ru.java_jabki.filmplus.model.Film;
import ru.java_jabki.filmplus.repository.FilmRepository;

import java.time.LocalDate;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class FilmService {
    private final FilmRepository films;

    public Film addfilm(final Film film) {
        validateFilm(film);
        films.insert(film);
        return film;
    }

    public Film getbyId(final Integer id) {
        return films.getById(id);
    }

    public void deleteFilm(final int id) {
        films.delete(id);
    }

    public void updateFilm(final Film film) {
       films.update(film);
    }

    private void validateFilm(Film film) {
        if (film == null) {
            throw new FilmException("Film is null");
        }
        if (!StringUtils.hasText(film.getName()) || !StringUtils.hasText(film.getDescription())) {
            throw new FilmException("One of the parameters is empty: name - " + film.getName() + " description - " + film.getDescription());
        }
        if (film.getDuration() < 0 || film.getDuration() > 720) {
            throw new FilmException("Duration is too long");
        }
        if (film.getReleaseDate() == null || film.getReleaseDate().isAfter(LocalDate.now())) {
            throw new FilmException("Date is incorrect");
        }
    }

    public List<Film> searchFilm(String name, String description, LocalDate releasedate,Integer duration ) {
        return films.search(name,description,releasedate,duration);
    }
}
