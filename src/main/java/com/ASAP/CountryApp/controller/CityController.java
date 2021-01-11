package com.ASAP.CountryApp.controller;

import com.ASAP.CountryApp.geo_api.City;

public interface CityController {
    City getInfoForTheCity(String countryName, String cityName);
}
