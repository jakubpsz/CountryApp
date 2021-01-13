package com.ASAP.CountryApp.service;

import com.ASAP.CountryApp.logic.geo.City;

public interface CityService {
    City getCity(String country, String cityName);
}
