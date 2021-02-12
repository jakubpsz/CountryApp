package com.asap.country_app.database.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id;

    //    @Email //TODO zrobic mail lower
    @Column(unique = true)
    private String email;
    private String password;

    @OneToOne (cascade = CascadeType.ALL)
    private UserInfo userInfo;

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(
            name = "location_visitedLocations",
            joinColumns = @JoinColumn(name = "location_id"),
            inverseJoinColumns = @JoinColumn(name = "visited_id")
    )
    private List<Location> visitedLocations;

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(
            name = "location_likedLocations",
            joinColumns = @JoinColumn(name = "location_id"),
            inverseJoinColumns = @JoinColumn(name = "likedLocations_id")
    )
    private List<Location> likedLocations;
    @ManyToMany
    @JoinTable(
            name = "location_locationWantedToVisit",
            joinColumns = @JoinColumn(name = "location_id"),
            inverseJoinColumns = @JoinColumn(name = "locationsWantedToVisit_id")
    )
    private List<Location> locationsWantedToVisit;


    public User(UUID id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public User(String email, String password, UserInfo userInfo, List<Location> visitedLocations, List<Location> likedLocations, List<Location> locationsWantedToVisit) {
        this.email = email;
        this.password = password;
        this.userInfo = userInfo;
        this.visitedLocations = visitedLocations;
        this.likedLocations = likedLocations;
        this.locationsWantedToVisit = locationsWantedToVisit;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
