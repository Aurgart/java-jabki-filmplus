package ru.java_jabki.filmplus.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.java_jabki.filmplus.exceptions.FilmException;
import ru.java_jabki.filmplus.exceptions.UserException;
import ru.java_jabki.filmplus.model.ApiError;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler({UserException.class, FilmException.class})
    public ResponseEntity<ApiError> handleError(RuntimeException Exception) {
        return ResponseEntity.badRequest().body(new ApiError(false, Exception.getMessage()));
    }
}
