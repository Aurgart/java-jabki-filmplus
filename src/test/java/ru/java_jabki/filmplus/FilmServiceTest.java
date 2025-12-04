package ru.java_jabki.filmplus;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.java_jabki.filmplus.model.Film;
import ru.java_jabki.filmplus.model.Genre;
import ru.java_jabki.filmplus.repository.FilmRepository;
import ru.java_jabki.filmplus.service.FilmService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class FilmServiceTest {

    @Mock
    private FilmRepository filmRepository;

    @InjectMocks
    private FilmService films;


    @Test
    void testAddFilm() {
        RuntimeException excp = assertThrows(RuntimeException.class, () -> films.addfilm(createFilm("Niggers", "Nigga shootout", LocalDate.parse("2000-01-20"), 1000L)));
        Assertions.assertNotNull(excp.getMessage());
        Assertions.assertDoesNotThrow(() -> {
            films.addfilm(createFilm("Niggers", "Nigga shootout", LocalDate.parse("2000-01-20"), 100L));
        });
    }

    private Film createFilm(String name, String description, LocalDate date, Long duration) {
        return Film.builder().id(1).name(name).description(description).releaseDate(date).duration(duration).genres(Set.of(Genre.COMEDY)).build();
    }
}
