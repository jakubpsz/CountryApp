package com.asap.country_app.controller;

import com.asap.country_app.dto.UserDto;
import com.asap.country_app.dto.UserInfoDto;
import com.asap.country_app.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //TODO Ivan ustawic status zeby byl inny gdy blad
    public UserDto saveUser(@RequestBody UserDto userDto) {
        return userService.saveUser(userDto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public UserInfoDto editUserInfo(@RequestBody UserDto userDto) {
        return userService.editUserInfo(userDto);
    }



//    @PutMapping
//    @ResponseStatus(HttpStatus.OK)
//    public UserInfoDto addVisitedLocation(@RequestBody UserDto userDto) {
//        return userService.addLikedLocation(userDto);
//    }
//
//    @PutMapping
//    @ResponseStatus(HttpStatus.OK)
//    public UserInfoDto addLocationWantedToVisit(@RequestBody UserDto userDto) {
//        return userService.addLikedLocation(userDto);
//    }


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
