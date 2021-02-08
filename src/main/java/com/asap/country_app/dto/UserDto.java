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

        private UserInfoDto userInfo;

        private List<LocationDto> visitedCities;

        private List<LocationDto> likedCities;

        private List<LocationDto> citiesWantedToVisit;

    public UserDto(String email, String password, UserInfoDto userInfo, List<LocationDto> visitedCities, List<LocationDto> likedCities, List<LocationDto> citiesWantedToVisit) {
        this.email = email;
        this.password = password;
        this.userInfo = userInfo;
        this.visitedCities = visitedCities;
        this.likedCities = likedCities;
        this.citiesWantedToVisit = citiesWantedToVisit;
    }
}


