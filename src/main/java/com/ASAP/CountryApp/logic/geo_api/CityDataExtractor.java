package com.ASAP.CountryApp.logic.geo_api;

import com.ASAP.CountryApp.logic.rest.HttpClient;
import com.ASAP.CountryApp.logic.weather.WeatherDataExtractor;
import com.ASAP.CountryApp.logic.wiki_data_api.WikiDataExtractor;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class CityDataExtractor {

    private HttpClient httpClient;
    private ResponseConverter responseConverter;
    private WeatherDataExtractor weatherDataExtractor;
    private WikiDataExtractor wikiDataExtractor;
    private CountryDataExtractor countryDataExtractor;

    @Autowired
    public CityDataExtractor(HttpClient httpClient, ResponseConverter responseConverter,
                             WeatherDataExtractor weatherDataExtractor, WikiDataExtractor wikiDataExtractor,
                             CountryDataExtractor countryDataExtractor) {
        this.httpClient = httpClient;
        this.responseConverter = responseConverter;
        this.weatherDataExtractor = weatherDataExtractor;
        this.wikiDataExtractor = wikiDataExtractor;
        this.countryDataExtractor = countryDataExtractor;
    }

    public CityDataExtractor() {
    }

    public City getData(String countryName, String cityName) throws UnirestException, InterruptedException {
        //get country
        Country country = countryDataExtractor.getData(countryName);
        TimeUnit.SECONDS.sleep(2);
        //get city info
        HttpResponse<JsonNode> response = httpClient.getCityData(country, cityName);
        City city = responseConverter.convertResponseToCity(response);
        city.setCountry(country);
        //get and set weather
        city.setWeather(weatherDataExtractor.getData(city));
        //get and set wikipedia link
        city.setUrl(wikiDataExtractor.getData(cityName));
        return city;
    }
}