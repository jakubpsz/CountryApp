package com.asap.country_app.database.Functions;

import com.asap.country_app.database.user.Location;
import com.asap.country_app.dto.LocationDto;

import java.util.function.Function;
import java.util.stream.Collectors;

import static com.asap.country_app.database.Functions.UserFunctions.userDTOToUser;
import static com.asap.country_app.database.Functions.UserFunctions.userToUserDTO;

public class LocationFunctions {

    public static final Function<Location, LocationDto> locationToLocationDTO = location -> new LocationDto(
            location.getId(),
            location.getCountry(),
            location.getCity()
    );

    public static final Function<LocationDto, Location> locationDTOToLocation = locationDto -> new Location(
            locationDto.getCountry(),
            locationDto.getCity()
    );

    public static final Function<Location, LocationDto> locationToLocationDTO1 = location -> new LocationDto(
            location.getId(),
            location.getCountry(),
            location.getCity(),
            location.getVisitedLocations().stream().map(userToUserDTO).collect(Collectors.toList()),
            location.getLocationsWantedToVisit().stream().map(userToUserDTO).collect(Collectors.toList()),
            location.getLikedLocations().stream().map(userToUserDTO).collect(Collectors.toList())
    );

    public static final Function<LocationDto, Location> locationDTOToLocation1 = locationDto -> new Location(
            locationDto.getCountry(),
            locationDto.getCity(),
            locationDto.getLikedLocationsDto().stream().map(userDTOToUser).collect(Collectors.toList()),
            locationDto.getVisitedLocationsDto().stream().map(userDTOToUser).collect(Collectors.toList()),
            locationDto.getLocationsWantedToVisitDto().stream().map(userDTOToUser).collect(Collectors.toList())
    );
}
