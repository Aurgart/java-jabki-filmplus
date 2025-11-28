package ru.java_jabki.filmplus.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.java_jabki.filmplus.exceptions.ReviewException;
import ru.java_jabki.filmplus.model.Like;
import ru.java_jabki.filmplus.model.Review;
import ru.java_jabki.filmplus.repository.ReviewRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReviewService {
    private final ReviewRepository reviews;

    public void addReviewToFilm(final Review review) {
        reviews.insert(review);
    }

    public void removeReviewFromFilm(Integer filmId, Long userId) {
        reviews.delete(userId,filmId);
    }

    public void updateReview(final Review review) {
        reviews.update(review);
    }

    public List<Review> getReviews(Integer filmId) {
        return reviews.getById(filmId);
    }
}
