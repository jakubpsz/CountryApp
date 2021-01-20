package com.asap.country_app.service;

import com.asap.country_app.user.User;
import com.asap.country_app.repository.Repository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final Repository repository;

    public UserServiceImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public boolean createUser(String email, String password) {
        return repository.addUserToRepository(new User(email, password));
    }
}
