package ru.java_jabki.filmplus.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.java_jabki.filmplus.model.Review;
import ru.java_jabki.filmplus.service.ReviewService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/review")
@Tag(name = "Ревью")
public class ReviewController {
    private final ReviewService reviewLogic;

    @PostMapping
    @Operation(summary = "Проревьить фильм")
    public void addReview(@RequestBody final Review review) {
        reviewLogic.addReviewToFilm(review);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить ревью по фильму")
    public List<Review> getById(@PathVariable("id") String filmId) {
        return reviewLogic.getReviews(Integer.parseInt(filmId));
    }

    @PatchMapping
    @Operation(summary = "Обновить ревью")
    public void update(@RequestBody final Review review) {
        reviewLogic.updateReview(review);
    }

    @DeleteMapping
    @Operation(summary = "Удалить ревью")
    public void delete(@RequestParam(required = true) String filmId, @RequestParam(required = true) String userId) {
        reviewLogic.removeReviewFromFilm(Integer.parseInt(filmId), Long.parseLong(userId));
    }
}
