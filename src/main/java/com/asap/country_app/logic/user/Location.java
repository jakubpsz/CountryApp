package com.asap.country_app.logic.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location {

    private String country;
    private String city;
    private boolean like;
    private boolean visited;
    private boolean wantToVisit;

}
