package com.ASAP.CountryApp.logic.geo_api;

import com.ASAP.CountryApp.logic.rest.HttpClient;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan (basePackages = "com.ASAP.CountryApp")
public class CountryDataExtractor {

    private HttpClient httpClient;
    private ResponseConverterGeo responseConverterGeo;

    @Autowired
    public CountryDataExtractor(HttpClient httpClient, ResponseConverterGeo responseConverterGeo) {
        this.httpClient = httpClient;
        this.responseConverterGeo = responseConverterGeo;
    }

    public CountryDataExtractor() {
    }

    public Country getData(String countryName) throws UnirestException {
        HttpResponse<JsonNode> response = httpClient.getCountryData(countryName);
        return responseConverterGeo.convertResponseToCountry(response);
    }
}
