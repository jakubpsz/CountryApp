package com.asap.country_app.dto;

import com.asap.country_app.database.user.User;
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

    private List<UserDto> visitedByCities;

    private List<UserDto> likedByCities;

    private List<UserDto> citiesWantedToVisitBy;

    public LocationDto(String country, String city, List<UserDto> visitedByCities, List<UserDto> likedByCities, List<UserDto> citiesWantedToVisitBy) {
        this.country = country;
        this.city = city;
        this.visitedByCities = visitedByCities;
        this.likedByCities = likedByCities;
        this.citiesWantedToVisitBy = citiesWantedToVisitBy;
    }


}
