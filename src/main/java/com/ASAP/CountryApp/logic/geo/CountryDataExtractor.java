package com.ASAP.CountryApp.logic.geo;

import com.ASAP.CountryApp.logic.currency.CurrencyExchangeDataExtractor;
import com.ASAP.CountryApp.logic.rest.HttpClient;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@ComponentScan (basePackages = "com.ASAP.CountryApp")
public class CountryDataExtractor {

    private HttpClient httpClient;
    private ResponseConverterGeo responseConverterGeo;
    private CurrencyExchangeDataExtractor currencyExchangeDataExtractor;

    @Autowired
    public CountryDataExtractor(HttpClient httpClient, ResponseConverterGeo responseConverterGeo, CurrencyExchangeDataExtractor currencyExchangeDataExtractor) {
        this.httpClient = httpClient;
        this.responseConverterGeo = responseConverterGeo;
        this.currencyExchangeDataExtractor = currencyExchangeDataExtractor;
    }

    public CountryDataExtractor() {
    }

    public Country getData(String countryName) throws UnirestException {
        HttpResponse<JsonNode> response = httpClient.getCountryData(countryName);
        Country country =  responseConverterGeo.convertResponseToCountry(response);
        country.setExchangeRate(Double.parseDouble(currencyExchangeDataExtractor.getData(country.getCurrency()
                .replace("[\"", "").replace("\"]", ""), "PLN")));
        return country;
    }
}
