package com.asap.country_app.service;

import com.asap.country_app.logic.user.Location;
import com.asap.country_app.logic.user.User;
import com.asap.country_app.logic.user.UserInfo;

import java.util.List;

public interface UserService {
    boolean createUser (User user);
    List<User> getUsers();
    boolean addLocation(String email, Location location);
    boolean addUserInfo(String email, UserInfo userInfo);
    public boolean removeUser(String email);

}
