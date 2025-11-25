package ru.java_jabki.filmplus.model;

public class Friends {
    private final Long firstFriend;
    private final Long secondFriend;

    public Friends(final Long firstFriend, final Long secondFriend) {
        this.firstFriend = firstFriend;
        this.secondFriend = secondFriend;
    }

    public Long getFirstFriend() {
        return this.firstFriend;
    }

    public Long getSecondFriend() {
        return this.secondFriend;
    }
}
