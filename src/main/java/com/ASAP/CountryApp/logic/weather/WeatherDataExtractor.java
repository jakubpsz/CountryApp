package com.ASAP.CountryApp.logic.weather;

import com.ASAP.CountryApp.logic.geo_api.City;
import com.ASAP.CountryApp.logic.rest.HttpClient;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Component;

@Component
public class WeatherDataExtractor {

    private final HttpClient httpClient;
    private final ResponseConverterWeather responseConverterWeather;

    public WeatherDataExtractor(HttpClient httpClient, ResponseConverterWeather responseConverterWeather) {
        this.httpClient = httpClient;
        this.responseConverterWeather = responseConverterWeather;
    }

    public Weather getData(City city) throws UnirestException {
        HttpResponse<JsonNode> response = httpClient.getWeatherData(city);
        return responseConverterWeather.convertResponseToWeather(response);
    }
}
