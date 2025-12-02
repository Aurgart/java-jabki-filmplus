package ru.java_jabki.filmplus;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.java_jabki.filmplus.model.Film;
import ru.java_jabki.filmplus.model.User;
import ru.java_jabki.filmplus.service.UserService;
import ru.java_jabki.filmplus.service.FilmService;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.java_jabki.filmplus.model.Genre.COMEDY;

@SpringBootTest
class FilmplusApplicationTests {
    @Test
    void contextLoads() {
    }
}
