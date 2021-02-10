package com.asap.country_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

        private UUID id;

        private String email;
        private String password;

        private UserInfoDto userInfoDto;

        private List<LocationDto> visitedLocations;

        private List<LocationDto> likedLocations;

        private List<LocationDto> locationsWantedToVisit;

    public UserDto(String email, String password, UserInfoDto userInfoDto, List<LocationDto> visitedLocations, List<LocationDto> likedLocations, List<LocationDto> locationsWantedToVisit) {
        this.email = email;
        this.password = password;
        this.userInfoDto = userInfoDto;
        this.visitedLocations = visitedLocations;
        this.likedLocations = likedLocations;
        this.locationsWantedToVisit = locationsWantedToVisit;
    }
}


