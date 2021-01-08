package com.ASAP.CountryApp.geo_api;

import com.ASAP.CountryApp.weather.Weather;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class City {
    private Country country;
    private String name;
    private String id;
    private String latitude;
    private String longitude;
    private Weather weather;
}
