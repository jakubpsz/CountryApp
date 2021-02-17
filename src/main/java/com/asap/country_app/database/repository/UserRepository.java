package com.asap.country_app.database.repository;

import com.asap.country_app.database.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    //TODO decide if leave as is or maybe better to insert in the database with lowercase
    @Query(value = "select u from User u where lower(email) = lower(:email)")
    Optional<User> findByEmail(String email);

}
