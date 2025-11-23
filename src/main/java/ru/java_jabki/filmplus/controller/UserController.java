package ru.java_jabki.filmplus.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import ru.java_jabki.filmplus.model.User;
import ru.java_jabki.filmplus.service.UserService;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/user")
@Tag(name = "Пользователь")
public class UserController {

    private UserService userLogic;

    public UserController(UserService users) {
        this.userLogic = users;
    }

    @PostMapping
    @Operation(summary = "Создать пользователя параметрами")
    public User createParam(@RequestParam(required = true) String name, @RequestParam(required = true) String email, @RequestParam(required = true) String login, @RequestParam(required = true) LocalDate birthday) {
        return userLogic.addUser(name, email, login, birthday);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить данные пользователя")
    public User getById(@PathVariable("id") String id) {
        return userLogic.getbyId(Long.parseLong(id));
    }

    @PatchMapping
    @Operation(summary = "Обновить данные пользователя")
    public void update(@RequestBody final User user) {
        userLogic.updateUser(user);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить пользователя")
    public void delete(@PathVariable("id") String id) {
        userLogic.deleteUser(Long.parseLong(id));
    }
}
