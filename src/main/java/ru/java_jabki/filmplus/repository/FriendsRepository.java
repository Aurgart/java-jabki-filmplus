package ru.java_jabki.filmplus.repository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import ru.java_jabki.filmplus.mappers.FriendsMapper;
import ru.java_jabki.filmplus.model.Friends;

import java.util.List;

@Component
@AllArgsConstructor
public class FriendsRepository {
    private static final String INSERT = """
            INSERT INTO filmplus.friends (user_id,friend_id)
            VALUES (:user_id, :friend_id)
            RETURNING *;
            """;
    private static final String DELETE = """
            DELETE filmplus.friends
            WHERE user_id = :user_id
            and friend_id = :friend_id
            """;
    private static final String GET_BY_ID = """
            SELECT *
            FROM filmplus.friends
            WHERE user_id = :user_id or friend_id = :user_id
            """;
    private final FriendsMapper friendsMapp;
    private final NamedParameterJdbcTemplate jbcTemplate;

    public Friends insert(final Friends niggas) {
        return jbcTemplate.queryForObject(INSERT, friendParamForSql(niggas), friendsMapp);
    }

    public void delete(final Long user_id, final Long nigga_id) {
        jbcTemplate.update(DELETE, friendParamForSql( new Friends(user_id,nigga_id)));
    }

    public List<Friends> getById(final Long user_id) {
        return jbcTemplate.query(GET_BY_ID,  new MapSqlParameterSource("user_id", user_id), friendsMapp);
    }

    public MapSqlParameterSource friendParamForSql(final Friends friend) {
        final MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("user_id", friend.getFirstFriend());
        params.addValue("friend_id", friend.getSecondFriend());
        return params;
    }

}
