package com.asap.country_app.service;

import com.asap.country_app.logic.geo.City;
import com.asap.country_app.logic.geo.CityDataExtractor;
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
