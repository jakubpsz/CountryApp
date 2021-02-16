package com.asap.country_app.dto;

import com.asap.country_app.database.user.Location;
import com.asap.country_app.database.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {

    private UUID id;
    private LocalDateTime created;
    private String text;

    private User user;
    private Location location;

    public CommentDto(LocalDateTime created, String text, User user, Location location) {
        this.created = created;
        this.text = text;
        this.user = user;
        this.location = location;
    }
}
