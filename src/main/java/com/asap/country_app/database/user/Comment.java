package com.asap.country_app.database.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @GeneratedValue
    @Id
    private UUID id;

    private LocalDateTime created;
    private String text;

    @ManyToOne
    private User user;
    @ManyToOne
    private Location location;

}
