package ru.java_jabki.filmplus.mappers;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.java_jabki.filmplus.model.Film;
import ru.java_jabki.filmplus.model.Genre;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

@Component
public class FilmMapper  implements RowMapper<Film> {

    @Override
    public Film mapRow(ResultSet rs, int rowNum) throws SQLException {
        Array genres = rs.getArray("genres");
        Set<Genre> genreSet = new HashSet<>();
        if(!(genres == null)) {
            for (String s : (String[]) genres.getArray()) {
                genreSet.add(Enum.valueOf(Genre.class, s));
            }
        }
        return Film.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .description(rs.getString("description"))
                .releaseDate(rs.getDate("releasedate").toLocalDate())
                .duration(rs.getLong("duration"))
                .genres(genreSet)
                .build();
    }
}
