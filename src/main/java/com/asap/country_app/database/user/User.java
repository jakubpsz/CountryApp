package com.asap.country_app.database.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
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


    //    @Email
    private String email;
    private String password;


    @OneToOne
    private UserInfo userInfo;

    @ManyToMany
    @JoinTable(
            name = "location_visitedLocations",
            joinColumns = @JoinColumn(name = "location_id"),
            inverseJoinColumns = @JoinColumn(name = "visited_id")
    )
    private List<Location> visitedLocations;
    @ManyToMany
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

    public User(String email, String password) {
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
}
