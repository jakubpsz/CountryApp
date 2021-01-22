package com.asap.country_app.controller;

import com.asap.country_app.service.UserService;
import com.asap.country_app.logic.user.User;
import com.asap.country_app.logic.user.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@Slf4j
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PutMapping("/register")
    public String addUser(@RequestBody UserDto userDto){
        log.info("Register user email={} password={}", userDto.getEmail(), userDto.getPassword());
        if(userService.createUser(userDto)){
            return "Success";
        }else {
            return "Failed";
        }
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

}
