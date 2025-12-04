package ru.java_jabki.filmplus.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class User {
    private Long id;
    private String login;
    private String name;
    private String email;
    private LocalDate birthday;
}
