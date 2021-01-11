package com.ASAP.CountryApp.logic.geo_api;

import com.ASAP.CountryApp.logic.rest.HttpClient;
import com.ASAP.CountryApp.logic.weather.WeatherDataExtractor;
import com.ASAP.CountryApp.logic.wiki_data_api.WikiDataExtractor;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.concurrent.TimeUnit;

public class CityDataExtractor {

    private final HttpClient httpClient = new HttpClient();
    private final ResponseConverter responseConverter = new ResponseConverter();
    private final WeatherDataExtractor weatherDataExtractor = new WeatherDataExtractor();
    private final WikiDataExtractor wikiDataExtractor = new WikiDataExtractor();
    private final CountryDataExtractor countryDataExtractor = new CountryDataExtractor();

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