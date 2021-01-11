package com.ASAP.CountryApp.service;

import com.ASAP.CountryApp.geo_api.City;

import javax.xml.transform.sax.SAXResult;

public interface CityService {
    City getCity(String country, String cityName);
}
