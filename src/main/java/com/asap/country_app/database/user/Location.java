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
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {

    @Id
    @GeneratedValue
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id;

    private String country;
    private String city;

    @ManyToMany
    @JoinTable(
            name = "user_visitedLocations",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "visitedLocations_id")
    )
    private List<User> visitedLocations;
    @ManyToMany
    @JoinTable(
            name = "user_likedLocations",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "likedLocation_id")
    )
    private List<User> likedLocations;
    @ManyToMany
    @JoinTable(
            name = "user_WantedToVisitLocations",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "locationsWantedToVisit_id")
    )
    private List<User> locationsWantedToVisit;

    public Location(String country, String city, List<User> visitedLocations, List<User> likedLocations, List<User> locationsWantedToVisit) {
        this.country = country;
        this.city = city;
        this.visitedLocations = visitedLocations;
        this.likedLocations = likedLocations;
        this.locationsWantedToVisit = locationsWantedToVisit;
    }
}
