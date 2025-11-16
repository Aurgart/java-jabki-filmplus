package ru.java_jabki.filmplus.service;

import org.springframework.stereotype.Service;
import ru.java_jabki.filmplus.model.Friends;
import ru.java_jabki.filmplus.model.Like;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class FriendsService {
    private List<Friends> bestFriends;

    public FriendsService() {
        this.bestFriends = new ArrayList<>();
        ;
    }

    public void befriendThatNigga(Long friend1, Long friend2) {
        bestFriends.add(new Friends(friend1, friend2));
    }

    public void hateThatNigga(Long friend1, Long friend2) {
        bestFriends.remove(new Friends(friend1, friend2));
    }

    public List<Friends> getBestNiggas(Long friend) {
        return bestFriends.stream().filter(f -> (!(friend == null) && (Objects.equals(f.getUserId1(), friend) || Objects.equals(f.getUserId2(), friend)))).toList();
    }
}
