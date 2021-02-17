package com.asap.country_app.database.Functions;

import com.asap.country_app.database.model.User;
import com.asap.country_app.dto.UserDto;

import java.util.function.Function;
import java.util.stream.Collectors;

import static com.asap.country_app.database.Functions.LocationFunctions.locationDTOToLocation;
import static com.asap.country_app.database.Functions.LocationFunctions.locationToLocationDTO;
import static com.asap.country_app.database.Functions.UserInfoFunctions.userInfoDTOToUserInfo;
import static com.asap.country_app.database.Functions.UserInfoFunctions.userInfoToUserInfoDTO;

public class UserFunctions {

    public static final Function<User, UserDto> userToUserDTOCreate = user ->  new UserDto(
            user.getId(),
            user.getEmail(),
            user.getPassword()
    );

    public static final Function<UserDto,User> userDTOToUserCreate = userDto -> new User(
            userDto.getEmail(),
            userDto.getPassword()
    );

    public static final Function<User, UserDto> userToUserDTO = user ->  new UserDto(
            user.getId(),
            user.getEmail(),
            user.getPassword(),
            userInfoToUserInfoDTO.apply(user.getUserInfo()),
            user.getLocationsWantedToVisit().stream().map(locationToLocationDTO).collect(Collectors.toList()),
            user.getLikedLocations().stream().map(locationToLocationDTO).collect(Collectors.toList()),
            user.getVisitedLocations().stream().map(locationToLocationDTO).collect(Collectors.toList())
    );

    public static final Function<UserDto,User> userDTOToUser = userDto -> new User(
            userDto.getEmail(),
            userDto.getPassword(),
            userInfoDTOToUserInfo.apply(userDto.getUserInfoDto()),
            userDto.getLocationsWantedToVisit().stream().map(locationDTOToLocation).collect(Collectors.toList()),
            userDto.getLikedLocations().stream().map(locationDTOToLocation).collect(Collectors.toList()),
            userDto.getVisitedLocations().stream().map(locationDTOToLocation).collect(Collectors.toList())
    );
}