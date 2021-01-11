package com.ASAP.CountryApp.service;

import com.ASAP.CountryApp.geo_api.City;
import com.ASAP.CountryApp.geo_api.CityDataExtractor;
import com.ASAP.CountryApp.geo_api.Country;
import com.ASAP.CountryApp.geo_api.CountryDataExtractor;
import com.ASAP.CountryApp.weather.WeatherDataExtractor;
import com.ASAP.CountryApp.wiki_data_api.WikiDataExtractor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class CityServiceImpl implements CityService{


    private final CityDataExtractor cityDataExtractor = new CityDataExtractor();
    private final WeatherDataExtractor weatherDataExtractor = new WeatherDataExtractor();
    private final CountryDataExtractor countryDataExtractor = new CountryDataExtractor();
    private final WikiDataExtractor wikiDataExtractor = new WikiDataExtractor();

    @SneakyThrows
    @Override
    public City getCity(String countryName, String cityName) {
        Country country = countryDataExtractor.getData(countryName);
        TimeUnit.SECONDS.sleep(2);
        City city = cityDataExtractor.getData(country, cityName);
        city.setWeather(weatherDataExtractor.getData(city));
        city.setUrl(wikiDataExtractor.getData(cityName));
        return city;
    }
}
