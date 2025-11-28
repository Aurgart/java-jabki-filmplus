package ru.java_jabki.filmplus.mappers;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.java_jabki.filmplus.model.Review;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ReviewMapper implements RowMapper<Review> {

    @Override
    public Review mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Review.builder()
                .userId(rs.getLong("user_id"))
                .filmId(rs.getInt("film_id"))
                .review(rs.getString("review"))
                .build();
    }

}
