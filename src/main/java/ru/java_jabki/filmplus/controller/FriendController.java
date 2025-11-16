package ru.java_jabki.filmplus.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import ru.java_jabki.filmplus.model.Friends;
import ru.java_jabki.filmplus.model.Like;
import ru.java_jabki.filmplus.service.FriendsService;
import ru.java_jabki.filmplus.service.LikeService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/friends")
@Tag(name = "Управления ниггами")
public class FriendController {
    private FriendsService niggaLogic;

    public FriendController(FriendsService friends) {
        this.niggaLogic = friends;
    }

    @PostMapping
    @Operation(summary = "Подружится")
    public void addFriend(@RequestBody final Friends friend) {
        niggaLogic.befriendThatNigga(friend.getUserId1(), friend.getUserId2());
    }

    @GetMapping("/id")
    @Operation(summary = "Получить Ниггу")
    public List<Friends> getById(@RequestParam(required = true) String userId) {
        return niggaLogic.getBestNiggas(Long.parseLong(userId));
    }

    @DeleteMapping
    @Operation(summary = "Убить Ниггу")
    public void delete(@RequestParam(required = true) String user1Id, @RequestParam(required = true) String user2Id) {
        niggaLogic.hateThatNigga(Long.parseLong(user1Id), Long.parseLong(user2Id));
    }
}
