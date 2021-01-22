package com.asap.country_app.service;

import com.asap.country_app.user.User;
import com.asap.country_app.user.UserDto;

import java.util.List;

public interface UserService {
    boolean createUser (UserDto userDTO);
    List<User> getUsers();
}
