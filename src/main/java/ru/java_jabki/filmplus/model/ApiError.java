package ru.java_jabki.filmplus.model;

import lombok.Data;

@Data
public class ApiError {
    final boolean success;
    final String message;
}

