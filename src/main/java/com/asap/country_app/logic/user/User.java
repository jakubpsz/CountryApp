package com.asap.country_app.logic.user;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
public class User {

//    @Email
    private String email;
    private String password;

    private UserInfo userInfo;
    private ArrayList<Location> places;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
