package com.asap.country_app.logic.user;

import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserDto convertUserToUserDTO(User user){
        UserDto userDTO = new UserDto();
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }

    public User convertUserDTOToUser(UserDto userDTO){
        return new User(userDTO.getEmail(), userDTO.getPassword());
    }
}
