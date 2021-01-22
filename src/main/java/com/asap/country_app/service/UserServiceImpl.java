package com.asap.country_app.service;

import com.asap.country_app.logic.user.Location;
import com.asap.country_app.repository.Repository;
import com.asap.country_app.logic.user.User;
import com.asap.country_app.logic.user.UserConverter;
import com.asap.country_app.logic.user.UserDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final Repository repository;
    private final UserConverter userConverter;

    public UserServiceImpl(Repository repository, UserConverter userConverter) {
        this.repository = repository;
        this.userConverter = userConverter;
    }

    @Override
    public boolean createUser(UserDto userDTO) {
        return repository.addUserToRepository(userConverter.convertUserDTOToUser(userDTO));
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
}
