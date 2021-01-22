package com.asap.country_app.service;

import com.asap.country_app.logic.user.Location;
import com.asap.country_app.logic.user.User;
import com.asap.country_app.logic.user.UserDto;

import java.util.List;

public interface UserService {
    boolean createUser (UserDto userDTO);
    List<User> getUsers();
    boolean addLocation(String email, Location location);
}
