package com.asap.country_app.service;

import com.asap.country_app.database.repository.LocationRepository;
import com.asap.country_app.database.user.Location;
import com.asap.country_app.dto.LocationDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.asap.country_app.database.Functions.LocationFunctions.locationDTOToLocation;
import static com.asap.country_app.database.Functions.LocationFunctions.locationToLocationDTO;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Transactional
    public LocationDto saveLocation(LocationDto locationDto) {

        if (locationRepository.findByCity(locationDto.getCity()).isEmpty()) {
            Location location = locationDTOToLocation.apply(locationDto);
            return locationToLocationDTO.apply(locationRepository.save(location));
        } else {
            return locationToLocationDTO.apply(locationRepository.findByCity(locationDto.getCity()).get());
        }
    }
}
