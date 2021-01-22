package com.asap.country_app.service;

import com.asap.country_app.logic.user.Location;
import com.asap.country_app.logic.user.User;

import java.util.List;

public interface UserService {
    boolean createUser (User user);
    List<User> getUsers();
    boolean addLocation(String email, Location location);
}
