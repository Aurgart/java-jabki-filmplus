package ru.java_jabki.filmplus.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.java_jabki.filmplus.model.Like;
import ru.java_jabki.filmplus.model.User;
import ru.java_jabki.filmplus.service.LikeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/like")
@Tag(name = "Лайки")
public class LikeController {
    private final LikeService likeLogic;

    @PostMapping
    @Operation(summary = "Лайк фильму")
    public void addLike(@RequestBody final Like like) {
        likeLogic.addLikeToFilm(like);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить лайки по фильму")
    public List<Like> getById(@PathVariable("id") String filmId) {
        return likeLogic.getLikes(Integer.parseInt(filmId));
    }

    @DeleteMapping
    @Operation(summary = "Удалить лайк")
    public void delete(@RequestParam(required = true) String filmId, @RequestParam(required = true) String userId) {
        likeLogic.removeLikeFromFilm(Integer.parseInt(filmId), Long.parseLong(userId));
    }
}
