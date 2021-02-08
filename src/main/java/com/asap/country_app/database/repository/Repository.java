package com.asap.country_app.database.repository;

import com.asap.country_app.database.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class Repository {

    private Map<String, User> repo = new HashMap<>();

    public boolean addUserToRepository(User user) {
        if (repo.containsKey(user.getEmail())) {
            log.error("This mail is in base");
            return false;
        } else {
            repo.put(user.getEmail(), user);
            log.info("Added user email={} password={}", user.getEmail(), user.getPassword());
            return true;
        }
    }

    public List<User> getAllUsers() {
        log.info("Getting all users");
        return new ArrayList<>(repo.values());
    }

    public User getByEmail(String email) {
        return repo.get(email);
    }

    public User removeUser(String email){
        return repo.remove(email);
    }
}