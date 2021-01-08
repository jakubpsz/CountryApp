package com.ASAP.CountryApp.weather;

import com.ASAP.CountryApp.geo_api.City;
import com.ASAP.CountryApp.rest.HttpClient;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;

public class WeatherDataExtractor {

    private final HttpClient httpClient = new HttpClient();
    private final ResponseConverter responseConverter = new ResponseConverter();

    public Weather getData(City city) throws UnirestException {
        HttpResponse<JsonNode> response = httpClient.getWeatherData(city);
        return responseConverter.convertResponseToWeather(response);
    }
}
