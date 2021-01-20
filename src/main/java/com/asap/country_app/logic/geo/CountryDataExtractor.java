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
    private final ResponseConverterGeo responseConverterGeo;
    private final CurrencyExchangeDataExtractor currencyExchangeDataExtractor;
    private final WikiDataExtractor wikiDataExtractor;

    @Autowired
    public CountryDataExtractor(HttpClient httpClient,
                                ResponseConverterGeo responseConverterGeo,
                                CurrencyExchangeDataExtractor currencyExchangeDataExtractor,
                                WikiDataExtractor wikiDataExtractor) {
        this.httpClient = httpClient;
        this.responseConverterGeo = responseConverterGeo;
        this.currencyExchangeDataExtractor = currencyExchangeDataExtractor;
        this.wikiDataExtractor = wikiDataExtractor;
    }

    //TODO getCountry()
    public Country getData(String countryName) throws UnirestException {
        HttpResponse<JsonNode> response = httpClient.getCountryData(countryName);
        Country country = responseConverterGeo.convertResponseToCountry(response);
        //TODO extract to separate method
        country.setExchangeRate(Double.parseDouble(currencyExchangeDataExtractor.getData(country.getCurrency()
                .replace("[\"", "").replace("\"]", ""), "PLN")));
        country.setWikipediaPage(wikiDataExtractor.getData(countryName));
        addFlagToCountry(country);
        return country;
    }

    private void addFlagToCountry(Country country) throws UnirestException {
        HttpResponse<JsonNode> flagResponse = httpClient.getFlag(country.getWikiId());
        country.setFlag(responseConverterGeo.convertResponseToFlag(flagResponse));
    }

    private double getExchangeRateFromString(String stringRate) {
        return 0;
    }
}
