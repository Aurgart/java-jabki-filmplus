package ru.java_jabki.filmplus.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.java_jabki.filmplus.model.User;
import ru.java_jabki.filmplus.service.UserService;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
@Tag(name = "Пользователь")
public class UserController {

    private final UserService userLogic;

    @PostMapping
    @Operation(summary = "Создать пользователя")
    public User createParam(@RequestBody final User user) {
        return userLogic.addUser(user);
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
