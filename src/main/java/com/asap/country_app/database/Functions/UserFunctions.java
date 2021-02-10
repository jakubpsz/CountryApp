package com.asap.country_app.database.Functions;

import com.asap.country_app.database.user.User;
import com.asap.country_app.dto.UserDto;

import java.util.function.Function;
import java.util.stream.Collectors;

import static com.asap.country_app.database.Functions.LocationFunctions.locationToLocationDTO;

public class UserFunctions {

    public static final Function<User, UserDto> userToUserDTO = user ->  new UserDto(
            user.getId(),
            user.getEmail(),
            user.getPassword(),
            user.getUserInfo(),
            user.getLikedLocations(),
            user.getLocationsWantedToVisit(),
            user.getVisitedLocations()
    );

    public static final Function<UserDto,User> userDTOToUser = userDto -> new User(
            userDto.getEmail(),
            userDto.getPassword(),
            userDto.getUserInfoDto(),
            userDto.getLikedLocations().stream().map(locationToLocationDTO).collect(Collectors.toList()),
            userDto.getLocationsWantedToVisit().stream().map(locationToLocationDTO).collect(Collectors.toList()),
            userDto.getVisitedLocations().stream().map(locationToLocationDTO).collect(Collectors.toList())
    );
}