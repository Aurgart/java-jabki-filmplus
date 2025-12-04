package ru.java_jabki.filmplus.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.java_jabki.filmplus.exceptions.UserException;
import ru.java_jabki.filmplus.model.Friends;
import ru.java_jabki.filmplus.repository.FriendsRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class FriendsService {
    private final FriendsRepository nigga;

    public Friends befriendThatNigga(final Friends niggas) {
        if(niggas.getFirstFriend() != niggas.getSecondFriend()) {
            return nigga.insert(niggas);
        }else{
            throw new UserException("You cant befriend yourself");
        }
    }

    public void hateThatNigga(Long firstFriend, Long secondFriend) {
        nigga.delete(firstFriend, secondFriend);
    }

    public List<Friends> getBestNiggas(Long friend) {
        return nigga.getById(friend);
    }
}
