package com.asap.country_app.database.Functions;

import com.asap.country_app.database.user.Location;
import com.asap.country_app.database.user.User;
import com.asap.country_app.dto.LocationDto;
import com.asap.country_app.dto.UserDto;

import java.util.function.Function;

public class LocationFunctions {

    public static final Function<Location, LocationDto> locationToLocationDTO = location ->  new LocationDto(
            location.getId(),
            location.getCountry(),
            location.getCity(),
            location.getVisitedLocations(),
            location.getLocationsWantedToVisit(),
            location.getLikedLocations()

    );

    public static final Function<LocationDto,Location> locationDTOToLocation = locationDto -> new Location(
            locationDto.getCountry(),
            locationDto.getCity(),
            locationDto.getLikedLocationsDto(),
            locationDto.getVisitedLocationsDto(),
            locationDto.getLocationsWantedToVisitDto()
            );
}
