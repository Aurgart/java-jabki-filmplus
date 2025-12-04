package ru.java_jabki.filmplus.repository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.java_jabki.filmplus.mappers.ReviewMapper;
import ru.java_jabki.filmplus.model.Review;
import java.util.List;

@Repository
@AllArgsConstructor
public class ReviewRepository {
    private static final String INSERT = """
            INSERT INTO filmplus.review (user_id,film_id, review)
            VALUES (:user_id, :film_id, :review)
            RETURNING *;
            """;
    private static final String UPDATE = """
            UPDATE filmplus.review
            SET review = :review
            WHERE user_id = :user_id
            and film_id = :film_id
            RETURNING *;
            """;
    private static final String DELETE = """
            DELETE filmplus.review
            WHERE user_id = :user_id
            and film_id = :film_id
            """;
    private static final String GET_BY_ID = """
            SELECT *
            FROM filmplus.review
            WHERE film_id = :film_id
            """;
    private final ReviewMapper reviewMapp;
    private final NamedParameterJdbcTemplate jbcTemplate;

    public Review insert(final Review review) {
        return jbcTemplate.queryForObject(INSERT, reviewParamForSql(review), reviewMapp);
    }

    public Review update(final Review review) {
        return jbcTemplate.queryForObject(UPDATE, reviewParamForSql(review), reviewMapp);
    }

    public void delete(final Long user_id, final int film_id) {
        jbcTemplate.update(DELETE, reviewIdsForSql(user_id,film_id));
    }

    public List<Review> getById(final int film_id) {
        return jbcTemplate.query(GET_BY_ID,  new MapSqlParameterSource("film_id", film_id), reviewMapp);
    }

    public MapSqlParameterSource reviewParamForSql(final Review review) {
        final MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue("user_id", review.getUserId());
        params.addValue("film_id", review.getFilmId());
        params.addValue("review", review.getReview());

        return params;
    }
    public MapSqlParameterSource reviewIdsForSql(final Long user_id, final int film_id) {
        final MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue("user_id", user_id);
        params.addValue("film_id", film_id);

        return params;
    }

}
