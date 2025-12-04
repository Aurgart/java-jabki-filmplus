package ru.java_jabki.filmplus.repository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.java_jabki.filmplus.mappers.LikeMapper;
import ru.java_jabki.filmplus.model.Like;

import java.util.List;

@Repository
@AllArgsConstructor
public class LikeRepository {
    private static final String INSERT = """
            INSERT INTO filmplus.like (user_id,film_id)
            VALUES (:user_id, :film_id)
            RETURNING *;
            """;
    private static final String DELETE = """
            DELETE filmplus.like
            WHERE user_id = :user_id
            and film_id = :film_id
            """;
    private static final String GET_BY_FILM_ID = """
            SELECT *
            FROM filmplus.like
            WHERE film_id = :film_id
            """;
    private final LikeMapper likeMapp;
    private final NamedParameterJdbcTemplate jbcTemplate;

    public Like insert(final Like like) {
        return jbcTemplate.queryForObject(INSERT, likeParamForSql(like), likeMapp);
    }

    public void delete(final Long user_id, final int film_id) {
        jbcTemplate.update(DELETE, likeIDsForSql(user_id,film_id));
    }

    public List<Like> getById(final int film_id) {
        return jbcTemplate.query(GET_BY_FILM_ID,  new MapSqlParameterSource("film_id", film_id), likeMapp);
    }

    private MapSqlParameterSource likeParamForSql(final Like like) {
        final MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("user_id", like.getUserId());
        params.addValue("film_id", like.getFilmId());
        return params;
    }
    private MapSqlParameterSource likeIDsForSql(final Long user_id, final int film_id) {
        final MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("user_id", user_id);
        params.addValue("film_id", film_id);
        return params;
    }

}
