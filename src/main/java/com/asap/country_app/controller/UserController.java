package com.asap.country_app.controller;

import com.asap.country_app.service.UserService;
import com.asap.country_app.logic.user.User;
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
    public String addUser(@RequestBody User user) {
        log.info("Register user email={} password={}", user.getEmail(), user.getPassword());
        if (userService.createUser(user)) {
            return "Success";
        } else {
            return "Failed";
        }
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        log.info("Requested all users");
        return userService.getUsers();
    }
}
