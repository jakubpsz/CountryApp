package com.asap.country_app.user;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
public class User {

    private String mail;
    private String password;

    private UserInfo userInfo;
    private ArrayList<Location> places;

    public User(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }
}
