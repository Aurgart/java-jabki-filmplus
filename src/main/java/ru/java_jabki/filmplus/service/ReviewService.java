package ru.java_jabki.filmplus.service;

import org.springframework.stereotype.Service;
import ru.java_jabki.filmplus.exceptions.ReviewException;
import ru.java_jabki.filmplus.model.Like;
import ru.java_jabki.filmplus.model.Review;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ReviewService {
    private List<Review> reviews;

    public ReviewService() {
        this.reviews = new ArrayList<>();
        ;
    }

    public void addReviewToFilm(Integer filmId, Long userId, String content) {
        if(!reviews.contains(new Review(userId, filmId, content))){
            reviews.add(new Review(userId, filmId, content));
        }
    }

    public void removeReviewFromFilm(Integer filmId, Long userId) {
        Review tmp = reviews.stream().filter(f -> (!(filmId == null) && Objects.equals(f.getFilmId(), filmId)) && (!(userId == null) && Objects.equals(f.getUserId(), userId))).findFirst()
                .orElseThrow(() -> new ReviewException("Не нашли отзыв"));
        reviews.remove(reviews.indexOf(tmp));
    }

    public void updateReview(Integer filmId, Long userId, String content) {
        Review tmp = reviews.stream().filter(f -> (!(filmId == null) && Objects.equals(f.getFilmId(), filmId)) && (!(userId == null) && Objects.equals(f.getUserId(), userId))).findFirst()
                .orElseThrow(() -> new ReviewException("Не нашли отзыв для обновления"));
        reviews.set(reviews.indexOf(tmp), new Review(tmp.getUserId(), tmp.getFilmId(), content));
    }

    public List<Review> getReviews(Integer filmId) {
        return reviews.stream().filter(f -> (!(filmId == null) && Objects.equals(f.getFilmId(), filmId))).toList();
    }
}
