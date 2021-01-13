package com.ASAP.CountryApp.logic.geo;

import com.ASAP.CountryApp.logic.weather.Weather;
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
    private String wikipediaPage;
}
