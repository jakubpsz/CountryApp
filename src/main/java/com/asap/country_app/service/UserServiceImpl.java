package com.asap.country_app.service;

import com.asap.country_app.logic.user.Location;
import com.asap.country_app.logic.user.UserInfo;
import com.asap.country_app.repository.Repository;
import com.asap.country_app.logic.user.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final Repository repository;

    public UserServiceImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public boolean createUser(User user) {
        return repository.addUserToRepository(user);
    }

    @Override
    public List<User> getUsers() {
        return repository.getAllUsers();
    }

    @Override
    public boolean addLocation(String email, Location location) {
        User user = repository.getByEmail(email);
        if(user == null){
            return false;
        }else {
            if (user.getPlaces() == null) {
                user.setPlaces(new ArrayList<>());
            }
            user.getPlaces().add(location);
            return true;
        }
    }
    @Override
    public boolean addUserInfo(String email, UserInfo userInfo) {
        User user = repository.getByEmail(email);
        if(user == null){
            return false;
        }else {
            user.setUserInfo(userInfo);
            return true;
        }
    }

    public boolean removeUser(String email){
        User user = repository.removeUser(email);
        return user != null;
    }
}
