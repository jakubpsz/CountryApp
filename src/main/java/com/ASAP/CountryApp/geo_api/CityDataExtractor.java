package com.ASAP.CountryApp.geo_api;

import com.ASAP.CountryApp.rest.HttpClient;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;

public class CityDataExtractor {

    @Autowired
    private HttpClient httpClient;
    @Autowired
    private ResponseConverter responseConverter;

    public City getData(Country country, String cityName) throws ParseException, UnirestException {
        City city = new City();
        city.setCountry(country);
        HttpResponse<JsonNode> response = httpClient.getCityData(country, cityName);
        return responseConverter.convertResponseToCity(response);
    }
}