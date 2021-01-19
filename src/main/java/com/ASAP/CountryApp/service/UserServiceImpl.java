package com.ASAP.CountryApp.service;

import com.ASAP.CountryApp.User.User;
import com.ASAP.CountryApp.repository.Repository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final Repository repository;

    public UserServiceImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public boolean createUser(String mail, String password) {
        return repository.addUserToRepository(new User(mail, password));
    }
}
