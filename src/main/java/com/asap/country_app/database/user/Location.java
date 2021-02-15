package com.asap.country_app.database.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

    @ManyToMany(mappedBy = "visitedLocations")
    private List<User> visitors;
    @ManyToMany(mappedBy = "likedLocations")
    private List<User> likes;
    @ManyToMany(mappedBy = "locationsWantedToVisit")
    private List<User> whoWantsToVisit;

    public Location(String country, String city, List<User> visitors, List<User> likes, List<User> whoWantsToVisit) {
        this.country = country;
        this.city = city;
        this.visitors = visitors;
        this.likes = likes;
        this.whoWantsToVisit = whoWantsToVisit;
    }

    public Location(String country, String city) {
        this.country = country;
        this.city = city;
    }
}
