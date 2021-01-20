package com.asap.country_app.logic.weather;

import com.asap.country_app.logic.geo.City;
import com.asap.country_app.logic.rest.HttpClient;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WeatherDataExtractor {

    private final HttpClient httpClient;
    private final ResponseConverterWeather responseConverterWeather;

    @Autowired
    public WeatherDataExtractor(HttpClient httpClient, ResponseConverterWeather responseConverterWeather) {
        this.httpClient = httpClient;
        this.responseConverterWeather = responseConverterWeather;
    }

    //TODO getWeather
    public Weather getData(City city) throws UnirestException {
        HttpResponse<JsonNode> response = httpClient.getWeatherData(city);
        return responseConverterWeather.convertResponseToWeather(response);
    }
}
