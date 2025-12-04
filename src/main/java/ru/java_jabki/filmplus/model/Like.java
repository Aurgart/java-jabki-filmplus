package ru.java_jabki.filmplus.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
public class Like {
    private final Long userId;
    private final Integer filmId;

    @Override
    public boolean equals(Object obj){
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Like tmp = (Like) obj;
        return Objects.equals(tmp.getFilmId(), this.filmId) && Objects.equals(tmp.getUserId(), this.userId);
    }
}
