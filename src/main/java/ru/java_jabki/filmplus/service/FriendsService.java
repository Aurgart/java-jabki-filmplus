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

    public void befriendThatNigga(Long firstFriend, Long secondFriend) {
        bestFriends.add(new Friends(firstFriend, secondFriend));
    }

    public void hateThatNigga(Long firstFriend, Long secondFriend) {
        bestFriends.remove(new Friends(firstFriend, secondFriend));
    }

    public List<Friends> getBestNiggas(Long friend) {
        return bestFriends.stream().filter(f -> (!(friend == null) && (Objects.equals(f.getFirstFriend(), friend) || Objects.equals(f.getSecondFriend(), friend)))).toList();
    }
}
