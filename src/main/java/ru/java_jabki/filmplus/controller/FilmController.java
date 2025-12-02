package ru.java_jabki.filmplus.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.java_jabki.filmplus.model.Film;
import ru.java_jabki.filmplus.service.FilmService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/film")
@Tag(name = "Фильм")
public class FilmController {

    private final FilmService filmLogic;

    @PostMapping
    @Operation(summary = "Создать фильм")
    public Film create(@RequestBody final Film film) {
        return filmLogic.addfilm(film);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить данные фильма")
    public Film getById(@PathVariable("id") String id) {
        return filmLogic.getbyId(Integer.parseInt(id));
    }

    @PatchMapping
    @Operation(summary = "Обновить описание или жанры для фильма")
    public void update(@RequestBody final Film film) {
        filmLogic.updateFilm(film);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить фильм")
    public void delete(@PathVariable("id") Integer id) {
        filmLogic.deleteFilm(id);
    }

    @GetMapping("/search")
    @Operation(summary = "Поиск фильма")
    public List<Film> searchFilm(@RequestParam(required = false) String name, @RequestParam(required = false) String description, @RequestParam(required = false) LocalDate releaseDate, @RequestParam(required = false) Integer duration) {
        return filmLogic.searchFilm(name,description,releaseDate,duration);
    }
}
