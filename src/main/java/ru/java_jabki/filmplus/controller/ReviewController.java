package ru.java_jabki.filmplus.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import ru.java_jabki.filmplus.model.Like;
import ru.java_jabki.filmplus.model.Review;
import ru.java_jabki.filmplus.service.LikeService;
import ru.java_jabki.filmplus.service.ReviewService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/review")
@Tag(name = "Ревью")
public class ReviewController {
    private ReviewService reviewLogic;

    public ReviewController(ReviewService reviews) {
        this.reviewLogic = reviews;
    }

    @PostMapping
    @Operation(summary = "Проревьить фильм")
    public void addReview(@RequestBody final Review review) {
        reviewLogic.addReviewToFilm(review.getFilmId(), review.getUserId(), review.getReview());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить ревью по фильму")
    public List<Review> getById(@PathVariable("id") String filmId) {
        return reviewLogic.getReviews(Integer.parseInt(filmId));
    }

    @PatchMapping
    @Operation(summary = "Обновить ревью")
    public void delete(@RequestParam(required = true) String filmId, @RequestParam(required = true) String userId, @RequestParam(required = true) String content) {
        reviewLogic.updateReview(Integer.parseInt(filmId), Long.parseLong(userId), content);
    }

    @DeleteMapping
    @Operation(summary = "Удалить ревью")
    public void delete(@RequestParam(required = true) String filmId, @RequestParam(required = true) String userId) {
        reviewLogic.removeReviewFromFilm(Integer.parseInt(filmId), Long.parseLong(userId));
    }
}
