package ru.java_jabki.filmplus.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.java_jabki.filmplus.exceptions.FilmException;
import ru.java_jabki.filmplus.exceptions.UserException;
import ru.java_jabki.filmplus.model.Film;
import ru.java_jabki.filmplus.model.User;
import ru.java_jabki.filmplus.repository.UserRepository;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository users;

    public User addUser(User user) {
        validateUser(user);
        users.insert(user);
        return user;
    }

    private void validateUser(User user) {
        if (user == null) {
            throw new UserException("User is null");
        }
        validateUserData(user.getName(), user.getEmail(), user.getLogin(), user.getBirthday());
    }

    private void validateUserData(String name, String email, String login, LocalDate birthday) {

        if (!StringUtils.hasText(email) || !StringUtils.hasText(name)) {
            throw new UserException("One of the parameters is empty: name - " + name + " email - " + email);
        }
        if (!StringUtils.hasText(login) || birthday.isAfter(LocalDate.now())) {
            throw new UserException("One of the parameters is empty: login - " + login + " birthday - " + birthday);
        }
    }

    public User getbyId(final Long id) {
        return users.getById(id);
    }

    public void deleteUser(final Long id) {
        users.delete(id);
    }

    public void updateUser(User user) {
        users.update(user);
    }

}
