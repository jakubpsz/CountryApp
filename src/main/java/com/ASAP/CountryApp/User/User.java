package com.ASAP.CountryApp.User;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
public class User {

    private String nickName;
    private String password;
    private String name;
    private String lastName;
    private String mail;
    private String dateOfBirth;
    private String codeOfCountry;
    private String currency;
    private ArrayList<Location> places;

    public User(String password, String mail) {
        this.password = password;
        this.mail = mail;
    }
}
