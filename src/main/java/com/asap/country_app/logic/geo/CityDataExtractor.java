package com.asap.country_app.logic.geo;

import com.asap.country_app.logic.rest.HttpClient;
import com.asap.country_app.logic.weather.WeatherDataExtractor;
import com.asap.country_app.logic.wiki_data.WikiDataExtractor;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CityDataExtractor {

    private final HttpClient httpClient;
    private final ResponseConverterGeo responseConverterGeo;
    private final WeatherDataExtractor weatherDataExtractor;
    private final WikiDataExtractor wikiDataExtractor;
    private final CountryDataExtractor countryDataExtractor;

    @Autowired
    public CityDataExtractor(HttpClient httpClient, ResponseConverterGeo responseConverterGeo,
                             WeatherDataExtractor weatherDataExtractor, WikiDataExtractor wikiDataExtractor,
                             CountryDataExtractor countryDataExtractor) {
        this.httpClient = httpClient;
        this.responseConverterGeo = responseConverterGeo;
        this.weatherDataExtractor = weatherDataExtractor;
        this.wikiDataExtractor = wikiDataExtractor;
        this.countryDataExtractor = countryDataExtractor;
    }

    //TODO getCity()
    public City getData(String countryName, String cityName) throws UnirestException {
        Country country = countryDataExtractor.getData(countryName);

        HttpResponse<JsonNode> response = httpClient.getCityData(country, cityName);
        City city = responseConverterGeo.convertResponseToCity(response);
        city.setCountry(country);
        city.setWeather(weatherDataExtractor.getData(city));
        city.setWikipediaPage(wikiDataExtractor.getData(cityName));
        return city;
    }
}
