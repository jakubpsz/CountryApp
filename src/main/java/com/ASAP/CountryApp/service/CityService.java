package com.ASAP.CountryApp.service;

import com.ASAP.CountryApp.logic.geo_api.City;

public interface CityService {
    City getCity(String country, String cityName);
}
