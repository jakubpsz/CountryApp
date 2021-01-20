package com.asap.country_app.logic.geo;

import com.asap.country_app.logic.currency.CurrencyExchangeDataExtractor;
import com.asap.country_app.logic.rest.HttpClient;
import com.asap.country_app.logic.wiki_data.WikiDataExtractor;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
//TODO check if this line is needed
@ComponentScan(basePackages = "com.asap.country_app")
public class CountryDataExtractor {

    private final HttpClient httpClient;
    private final HttpResponseConverter httpResponseConverter;
    private final CurrencyExchangeDataExtractor currencyExchangeDataExtractor;
    private final WikiDataExtractor wikiDataExtractor;

    @Autowired
    public CountryDataExtractor(HttpClient httpClient,
                                HttpResponseConverter httpResponseConverter,
                                CurrencyExchangeDataExtractor currencyExchangeDataExtractor,
                                WikiDataExtractor wikiDataExtractor) {
        this.httpClient = httpClient;
        this.httpResponseConverter = httpResponseConverter;
        this.currencyExchangeDataExtractor = currencyExchangeDataExtractor;
        this.wikiDataExtractor = wikiDataExtractor;
    }


    public Country getCountry(String countryName) throws UnirestException {
        HttpResponse<JsonNode> response = httpClient.getCountryData(countryName);
        Country country = httpResponseConverter.convertResponseToCountry(response);
        //TODO extract to separate method
        country.setExchangeRate(Double.parseDouble(currencyExchangeDataExtractor
                .getExchangeRate(country.getCurrency(), "PLN"))); //TODO change to currency of user
        country.setWikipediaUrl(wikiDataExtractor.getData(countryName));
        addFlagToCountry(country);
        return country;
    }

    private void addFlagToCountry(Country country) throws UnirestException {
        HttpResponse<JsonNode> flagResponse = httpClient.getFlag(country.getWikiId());
        country.setFlagUrl(httpResponseConverter.convertResponseToFlag(flagResponse));
    }

    private double getExchangeRateFromString(String stringRate) {
        return 0;
    }
}
