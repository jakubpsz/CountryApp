package com.asap.country_app.controller;

import com.asap.country_app.database.user.Location;
import com.asap.country_app.database.user.UserInfo;
import com.asap.country_app.database.user.User;
import com.asap.country_app.dto.UserDto;
import com.asap.country_app.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserDto saveUser(@RequestBody UserDto userDto) {
        return userService.saveUser(userDto);
    }


//    @CrossOrigin
//    @PutMapping("/register")
//    public String addUser(@RequestBody User user) {
//        log.info("Register user email={} password={}", user.getEmail(), user.getPassword());
//        if (userService.createUser(user)) {
//            return "Success register for " + user.getEmail();
//        } else {
//            return "Failed register for " + user.getEmail();
//        }
//    }
//
//    @GetMapping("/users")
//    public List<User> getUsers() {
//        log.info("Requested all users");
//        return userService.getUsers();
//    }
//
//    @PutMapping("/location/{email}")
//    public String addLocation(@RequestBody Location location, @PathVariable String email) {
//        if (userService.addLocation(email, location)) {
//            return "Success";
//        } else {
//            return "Failed";
//        }
//    }
//
//    @PutMapping("/info/{email}")
//    public String addInfo(@RequestBody UserInfo userInfo, @PathVariable String email) {
//        if (userService.addUserInfo(email, userInfo)) {
//            return "Success";
//        } else {
//            return "Failed";
//        }
//    }
//
//    @DeleteMapping("/delete/{email}")
//    public String deleteUser(@PathVariable String email) {
//        if (userService.removeUser(email)) {
//            return "Success";
//        } else {
//            return "Failed";
//        }
//    }
}
