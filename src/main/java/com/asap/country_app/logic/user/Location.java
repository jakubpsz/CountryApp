package com.asap.country_app.logic.user;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Getter
@Setter
public class Location {

    private String country;
    private String city;
    private boolean like;
    private boolean visited;
    private boolean wantToVisit;

}
