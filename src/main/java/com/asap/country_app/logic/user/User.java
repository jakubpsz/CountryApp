package com.asap.country_app.logic.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

    @OneToOne(mappedBy = "user")
    private UserInfo userInfo;

    @ManyToMany
    private List<Location> visitedCities;
    @ManyToMany
    private List<Location> likedCities;
    @ManyToMany
    private List<Location> citiesWantedToVisit;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
