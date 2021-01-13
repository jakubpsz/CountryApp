package com.ASAP.CountryApp.service;

import com.ASAP.CountryApp.logic.geo.City;
import com.ASAP.CountryApp.logic.geo.CityDataExtractor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    private final CityDataExtractor cityDataExtractor;

    public CityServiceImpl(CityDataExtractor cityDataExtractor) {
        this.cityDataExtractor = cityDataExtractor;
    }

    @SneakyThrows
    @Override
    public City getCity(String countryName, String cityName) {
        return cityDataExtractor.getData(countryName, cityName);
    }
}
