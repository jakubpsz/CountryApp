package com.asap.country_app.database.repository;

import com.asap.country_app.database.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {


}
