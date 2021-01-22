package com.asap.country_app.controller;

import com.asap.country_app.logic.user.Location;
import com.asap.country_app.service.UserService;
import com.asap.country_app.logic.user.User;
import com.asap.country_app.logic.user.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Slf4j
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PutMapping("/register")
    public String addUser(@RequestBody UserDto userDto) {
        log.info("Register user email={} password={}", userDto.getEmail(), userDto.getPassword());
        if (userService.createUser(userDto)) {
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

    @PutMapping("/location/{email}")
    public String addLocation(@RequestBody Location location, @PathVariable String email) {
        if (userService.addLocation(email, location)) {
            return "Success";
        } else {
            return "Failed";
        }
    }
}
