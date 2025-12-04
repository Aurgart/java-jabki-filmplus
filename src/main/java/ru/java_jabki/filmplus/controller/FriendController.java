package ru.java_jabki.filmplus.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.java_jabki.filmplus.model.Friends;
import ru.java_jabki.filmplus.service.FriendsService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/friends")
@Tag(name = "Управления ниггами")
public class FriendController {
    private final FriendsService niggaLogic;

    @PostMapping
    @Operation(summary = "Подружится")
    public void addFriend(@RequestBody final Friends friend) {
        niggaLogic.befriendThatNigga(friend);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить Ниггу")
    public List<Friends> getById(@PathVariable("id") String userId) {
        return niggaLogic.getBestNiggas(Long.parseLong(userId));
    }

    @DeleteMapping
    @Operation(summary = "Убить Ниггу")
    public void delete(@RequestParam(required = true) Long firstFriend, @RequestParam(required = true) Long secondFriend) {
        niggaLogic.hateThatNigga(firstFriend, secondFriend);
    }
}
