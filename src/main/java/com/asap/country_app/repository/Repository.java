package com.asap.country_app.repository;

import com.asap.country_app.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public List<User> getAllUsers(){
        return new ArrayList<>(repo.values());
    }
}
