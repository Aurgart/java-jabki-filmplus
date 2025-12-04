package ru.java_jabki.filmplus;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.java_jabki.filmplus.model.User;
import ru.java_jabki.filmplus.repository.UserRepository;
import ru.java_jabki.filmplus.service.UserService;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService users;

    @Test
    void testAddUser() {

        RuntimeException excp = assertThrows(RuntimeException.class, () -> users.addUser(createUser("", "Test", "bk@ru", LocalDate.parse("2000-10-08"))));
        Assertions.assertNotNull(excp.getMessage());
        Assertions.assertDoesNotThrow(() -> {
            users.addUser(createUser("nigga", "Test", "bk@ru", LocalDate.parse("2000-10-08")));
        });
    }

    private User createUser(String name, String login, String email, LocalDate date) {
        return User.builder().id(1L).name(name).login(login).email(email).birthday(date).build();
    }
}
