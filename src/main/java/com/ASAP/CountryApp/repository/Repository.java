package com.ASAP.CountryApp.repository;

import com.ASAP.CountryApp.User.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class Repository {

    private Map<String, User> repo = new HashMap<>();

    public boolean addUserToRepository(User user) {
        if (repo.keySet().contains(user.getMail())){
            log.warn("This mail is in base");
            return false;
        } else {
            repo.put(user.getMail(), user);
            return true;
        }
    }



}
