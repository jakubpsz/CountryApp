package com.ASAP.CountryApp.geo_api;

import com.ASAP.CountryApp.rest.HttpClient;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.simple.parser.ParseException;

public class CityDataExtractor {

    private final HttpClient httpClient = new HttpClient();
    private final ResponseConverter responseConverter = new ResponseConverter();

    public City getData(Country country, String cityName) throws ParseException, UnirestException {
        HttpResponse<JsonNode> response = httpClient.getCityData(country, cityName);
        City city = responseConverter.convertResponseToCity(response);
        city.setCountry(country);
        return responseConverter.convertResponseToCity(response);
    }
}