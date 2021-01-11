package com.ASAP.CountryApp.logic.geo_api;

import com.ASAP.CountryApp.logic.rest.HttpClient;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;

public class CountryDataExtractor {
    private final HttpClient httpClient = new HttpClient();
    private final ResponseConverter responseConverter = new ResponseConverter();

    public Country getData(String countryName) throws UnirestException {
        HttpResponse<JsonNode> response = httpClient.getCountryData(countryName);
        return responseConverter.convertResponseToCountry(response);
    }
}
