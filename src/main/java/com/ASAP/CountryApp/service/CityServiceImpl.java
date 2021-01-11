package com.ASAP.CountryApp.service;

import com.ASAP.CountryApp.geo_api.City;
import com.ASAP.CountryApp.geo_api.CityDataExtractor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {


    private final CityDataExtractor cityDataExtractor = new CityDataExtractor();

    @SneakyThrows
    @Override
    public City getCity(String countryName, String cityName) {
        return cityDataExtractor.getData(countryName, cityName);
    }
}
