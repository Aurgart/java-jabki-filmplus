package ru.java_jabki.filmplus.repository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.java_jabki.filmplus.mappers.FilmMapper;
import ru.java_jabki.filmplus.model.Film;

import java.time.LocalDate;
import java.util.List;

@Repository
@AllArgsConstructor
public class FilmRepository {
    private static final String INSERT = """
            INSERT INTO filmplus.film (name,description, release_date, duration, genres)
            VALUES (:name, :description, :release_date, :duration, :genres::genre[])
            RETURNING *;
            """;
    private static final String UPDATE = """
            UPDATE filmplus.film
            SET name = :name,
                description = :description,
                release_date = :release_date,
                duration = :duration,
                genres = :genres::genre[]
            WHERE id = :id
            RETURNING *;
            """;
    private static final String DELETE = """
            DELETE filmplus.film
            WHERE id = :id
            """;
    private static final String GET_BY_ID = """
            SELECT *
            FROM filmplus.film
            WHERE id = :id
            """;

    private static final String SEARCH = """
            SELECT *
            FROM filmplus.film
            WHERE name like '%'||:name||'%'
               OR description like '%'||:description||'%'
               OR release_date = :release_date
               OR duration = :duration
            """;


    private final FilmMapper filmMapp;
    private final NamedParameterJdbcTemplate jbcTemplate;

    public Film insert(final Film film){
        return jbcTemplate.queryForObject(INSERT, filmParamForSQL(film), filmMapp);
    }
    public Film update(final Film film){
        return jbcTemplate.queryForObject(UPDATE, filmParamForSQL(film), filmMapp);
    }
    public void delete(final int id) {
        jbcTemplate.update(DELETE, new MapSqlParameterSource("id", id));
    }
    public Film getById(final int id) {
        return jbcTemplate.queryForObject(GET_BY_ID, new MapSqlParameterSource("id", id), filmMapp);
    }
    public List<Film> search(String name, String description, LocalDate releasedate, Integer duration ){
        return jbcTemplate.query(SEARCH,filmParamForSearchSQL(name,description,releasedate,duration), filmMapp);
    }

    private MapSqlParameterSource filmParamForSQL(final Film film){
        final MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue("id", film.getId());
        params.addValue("name", film.getName());
        params.addValue("description", film.getDescription());
        params.addValue("release_date", film.getReleaseDate());
        params.addValue("duration", film.getDuration());
        if (film.getGenres() != null && !film.getGenres().isEmpty()) {
            String[] stringArray = film.getGenres().stream()
                    .map(Enum::name) // or .map(Object::toString)
                    .toArray(String[]::new);
            params.addValue("genres", stringArray);
        }else{
            params.addValue("genres", null);
        }

        return params;
    }

    private MapSqlParameterSource filmParamForSearchSQL(String name, String description, LocalDate releasedate, Integer duration) {
        final MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", name);
        params.addValue("description", description);
        params.addValue("release_date", releasedate);
        params.addValue("duration", duration);
        return params;
    }
}
