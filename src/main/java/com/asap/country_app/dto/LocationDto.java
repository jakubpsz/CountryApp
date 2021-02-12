package com.asap.country_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationDto {


    private UUID id;

    private String country;
    private String city;

    private List<UserDto> visitedLocationsDto;

    private List<UserDto> likedLocationsDto;

    private List<UserDto> locationsWantedToVisitDto;

    public LocationDto(UUID id, String country, String city) {
        this.id = id;
        this.country = country;
        this.city = city;
    }

    public LocationDto(String country, String city) {
        this.country = country;
        this.city = city;
    }
}
