package ru.java_jabki.filmplus.repository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.java_jabki.filmplus.mappers.UserMapper;
import ru.java_jabki.filmplus.model.User;

@Repository
@AllArgsConstructor
public class UserRepository {
    private static final String INSERT = """
            INSERT INTO filmplus.user (login,name,email, birthday)
            VALUES (:login, :name, :email, :birthday)
            RETURNING *;
            """;
    private static final String UPDATE = """
            UPDATE filmplus.user
            SET login = :login, name = :name, email = :email, birthday = :birthday
            WHERE id = :id
            RETURNING *;
            """;
    private static final String DELETE = """
            DELETE filmplus.user
            WHERE id = :id
            """;
    private static final String GET_BY_ID = """
            SELECT *
            FROM filmplus.user
            WHERE id = :id
            """;

    private final UserMapper userMapp;
    private final NamedParameterJdbcTemplate jbcTemplate;

    public User insert(final User user) {
        return jbcTemplate.queryForObject(INSERT, userParamForSql(user), userMapp);
    }

    public User update(final User user) {
        return jbcTemplate.queryForObject(UPDATE, userParamForSql(user), userMapp);
    }

    public void delete(final Long id) {
        jbcTemplate.update(DELETE, new MapSqlParameterSource("id", id));
    }

    public User getById(final Long id) {
        return jbcTemplate.queryForObject(GET_BY_ID, new MapSqlParameterSource("id", id), userMapp);

    }

    public MapSqlParameterSource userParamForSql(final User user) {
        final MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue("id", user.getId());
        params.addValue("name", user.getName());
        params.addValue("email", user.getEmail());
        params.addValue("login", user.getLogin());
        params.addValue("birthday", user.getBirthday());

        return params;
    }
}
