package ru.java_jabki.filmplus.mappers;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.java_jabki.filmplus.model.Friends;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class FriendsMapper implements RowMapper<Friends> {

    @Override
    public Friends mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Friends.builder()
               .firstFriend(rs.getLong("user_id"))
               .secondFriend(rs.getLong("friend_id"))
               .build();
    }
}
