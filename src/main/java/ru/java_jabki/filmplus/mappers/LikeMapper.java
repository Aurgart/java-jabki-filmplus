package ru.java_jabki.filmplus.mappers;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.java_jabki.filmplus.model.Like;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class LikeMapper implements RowMapper<Like> {

    @Override
    public Like mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Like.builder()
               .filmId(rs.getInt("film_id"))
               .userId(rs.getLong("user_id"))
               .build();
    }
}
