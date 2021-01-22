package com.asap.country_app.service;

import com.asap.country_app.repository.Repository;
import com.asap.country_app.logic.user.User;
import org.springframework.stereotype.Service;

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
}
