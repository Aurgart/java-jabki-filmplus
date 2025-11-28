package ru.java_jabki.filmplus.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.java_jabki.filmplus.model.Like;
import ru.java_jabki.filmplus.repository.LikeRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class LikeService {
    private final LikeRepository likes;

    public void addLikeToFilm(final Like like) {
        likes.insert(like);
    }

    public void removeLikeFromFilm(Integer filmId, Long userId) {
        likes.delete(userId, filmId);
    }

    public List<Like> getLikes(Integer filmId) {
        return likes.getById(filmId);
    }
}
