package com.asap.country_app.user;

import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserDTO convertUserToUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setMail(user.getMail());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }

    public User convertUserDTOToUser(UserDTO userDTO){
        return new User(userDTO.getMail(), userDTO.getPassword());
    }
}
