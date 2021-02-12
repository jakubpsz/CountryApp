package com.asap.country_app.database.repository;

import com.asap.country_app.database.user.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface LocationRepository extends JpaRepository <Location, UUID> {

    Optional<Location> findByCity (String city);
}
