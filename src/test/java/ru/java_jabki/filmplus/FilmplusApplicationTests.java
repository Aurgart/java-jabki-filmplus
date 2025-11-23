package ru.java_jabki.filmplus;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.java_jabki.filmplus.model.Film;
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

    @Test
    void testAddUser() {
        UserService tmp = new UserService();
        RuntimeException excp = assertThrows(RuntimeException.class, () -> tmp.addUser("", "mail@bk.ru", "test", LocalDate.parse("2000-10-08")));
        Assertions.assertNotNull(excp.getMessage());
        Assertions.assertDoesNotThrow(() -> {
            tmp.addUser("ttt", "mail@bk.ru", "test", LocalDate.parse("2000-10-08"));
        });
    }

    @Test
    void testAddFilm() {
        //String name, String description, LocalDate releaseDate, Long duration, Set<Genre> genres
        FilmService tmp = new FilmService();
        RuntimeException excp = assertThrows(RuntimeException.class, () -> tmp.addfilm(new Film("Ne grozi Centralu", "Niggeri", LocalDate.parse("2000-01-20"), (long) 1000, Set.of(COMEDY))));
        Assertions.assertNotNull(excp.getMessage());
        Assertions.assertDoesNotThrow(() -> {
            tmp.addfilm(new Film("Ne grozi Centralu", "Niggeri", LocalDate.parse("2000-01-20"), (long) 120, Set.of(COMEDY)));
        });
    }
}
