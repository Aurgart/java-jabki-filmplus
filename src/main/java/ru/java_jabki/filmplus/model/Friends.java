package ru.java_jabki.filmplus.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Friends {
    private final Long firstFriend;
    private final Long secondFriend;
}
