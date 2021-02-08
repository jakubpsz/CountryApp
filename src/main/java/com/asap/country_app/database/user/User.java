package com.asap.country_app.database.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.CascadeType;
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


    //@OneToOne(mappedBy = "user")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userInfo_id", referencedColumnName = "id")
    private UserInfo userInfo;

    @ManyToMany
    @JoinTable(
            name = "location_visitedCities",
            joinColumns = @JoinColumn(name = "location_id"),
            inverseJoinColumns = @JoinColumn(name = "visited_id")
    )
    private List<Location> visitedCities;
    @ManyToMany
    @JoinTable(
            name = "location_likedCities",
            joinColumns = @JoinColumn(name = "location_id"),
            inverseJoinColumns = @JoinColumn(name = "likedCities_id")
    )
    private List<Location> likedCities;
    @ManyToMany
    @JoinTable(
            name = "location_citiesWantedToVisit",
            joinColumns = @JoinColumn(name = "location_id"),
            inverseJoinColumns = @JoinColumn(name = "citiesWantedToVisit_id")
    )
    private List<Location> citiesWantedToVisit;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
