package ru.java_jabki.filmplus.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.java_jabki.filmplus.exceptions.FilmException;
import ru.java_jabki.filmplus.exceptions.UserException;
import ru.java_jabki.filmplus.model.Film;
import ru.java_jabki.filmplus.model.User;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
public class UserService {
    private static Set<User> users = new HashSet<>();

    public User addUser(final User user) {
        validateUser(user);
        users.add(user);
        return user;
    }

    private void validateUser(User user) {
        if (user == null) {
            throw new UserException("User is null");
        }
        if (!StringUtils.hasText(user.getEmail()) || !StringUtils.hasText(user.getName())) {
            throw new UserException("One of the parameters is empty: name - " + user.getName() + " email - " + user.getEmail());
        }
    }

    public User getbyId(final Long id) {
        return users.stream().filter(f -> Objects.equals(f.getId(), id)).findFirst().orElseThrow(() -> new FilmException("Movie not found"));
    }

    public void deleteUser(final Long id) {
        users.remove(getbyId(id));
    }

    public void updateUser(User user) {
        User tmp = getbyId(user.getId());
        tmp.setName(user.getName());
        tmp.setEmail(user.getEmail());
        tmp.setBirthday(user.getBirthday());
    }

}
