package ru.java_jabki.filmplus.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.java_jabki.filmplus.model.Like;
import ru.java_jabki.filmplus.repository.LikeRepository;

import java.util.List;

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
