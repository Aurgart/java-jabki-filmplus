package ru.java_jabki.filmplus.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.java_jabki.filmplus.model.Like;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Service
public class LikeService {
    private List<Like> likes;

    public LikeService() {
        this.likes = new ArrayList<>();
    }

    public void addLikeToFilm(Integer filmId, Long userId) {
        if (!likes.contains(new Like(userId, filmId))){
            likes.add(new Like(userId, filmId));
        }
    }

    public void removeLikeFromFilm(Integer filmId, Long userId) {
        likes.remove(new Like(userId, filmId));
    }

    public List<Like> getLikes(Integer filmId) {
        return likes.stream().filter(f -> (!(filmId == null) && Objects.equals(f.getFilmId(), filmId))).toList();
    }
}
