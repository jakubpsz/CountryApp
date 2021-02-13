package com.asap.country_app.service;

import com.asap.country_app.database.repository.LocationRepository;
import com.asap.country_app.database.user.Location;
import com.asap.country_app.dto.LocationDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static com.asap.country_app.database.Functions.LocationFunctions.locationDTOToLocation;
import static com.asap.country_app.database.Functions.LocationFunctions.locationToLocationDTO;

@Service
@Slf4j
public class LocationService {

    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Transactional
    public LocationDto saveLocation(LocationDto locationDto) {

        Optional<List<Location>> locationOpt = locationRepository.findAllByCity(locationDto.getCity());

        if (locationOpt.isPresent()) {
            for (Location l : locationOpt.get()) {
                if (l.getCountry().equals(locationDto.getCountry())) {
                    log.info("Location existed early");
                    return locationToLocationDTO.apply(locationRepository.save(l));
                }
            }
        }
        Location location = locationDTOToLocation.apply(locationDto);
        log.info("Save Location");
        return locationToLocationDTO.apply(locationRepository.save(location));
    }
}
