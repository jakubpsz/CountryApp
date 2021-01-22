package com.asap.country_app.service;

import com.asap.country_app.repository.Repository;
import com.asap.country_app.user.UserConverter;
import com.asap.country_app.user.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final Repository repository;
    private final UserConverter userConverter;

    public UserServiceImpl(Repository repository, UserConverter userConverter) {
        this.repository = repository;
        this.userConverter = userConverter;
    }

    @Override
    public boolean createUser(UserDTO userDTO) {
        return repository.addUserToRepository(userConverter.convertUserDTOToUser(userDTO));
    }
}
