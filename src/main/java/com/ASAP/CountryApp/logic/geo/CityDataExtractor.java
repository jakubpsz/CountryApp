package com.ASAP.CountryApp.logic.geo;

import com.ASAP.CountryApp.logic.rest.HttpClient;
import com.ASAP.CountryApp.logic.weather.WeatherDataExtractor;
import com.ASAP.CountryApp.logic.wiki_data.WikiDataExtractor;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CityDataExtractor {

    private final HttpClient httpClient;
    private final ResponseConverterGeo responseConverterGeo;
    private final WeatherDataExtractor weatherDataExtractor;
    private final WikiDataExtractor wikiDataExtractor;
    private final CountryDataExtractor countryDataExtractor;

    @Autowired
    public CityDataExtractor(HttpClient httpClient, ResponseConverterGeo responseConverterGeo,
                             WeatherDataExtractor weatherDataExtractor, WikiDataExtractor wikiDataExtractor,
                             CountryDataExtractor countryDataExtractor) {
        this.httpClient = httpClient;
        this.responseConverterGeo = responseConverterGeo;
        this.weatherDataExtractor = weatherDataExtractor;
        this.wikiDataExtractor = wikiDataExtractor;
        this.countryDataExtractor = countryDataExtractor;
    }

    public City getData(String countryName, String cityName) throws UnirestException, InterruptedException {
        //get country
        Country country = countryDataExtractor.getData(countryName);
        //get city info
        HttpResponse<JsonNode> response = httpClient.getCityData(country, cityName);
        City city = responseConverterGeo.convertResponseToCity(response);
        city.setCountry(country);
        city.setWeather(weatherDataExtractor.getData(city));
        city.setWikipediaPage(wikiDataExtractor.getData(cityName));
        return city;
    }
}