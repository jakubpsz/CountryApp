package com.ASAP.CountryApp.logic.rest;

import com.ASAP.CountryApp.logic.geo.City;
import com.ASAP.CountryApp.logic.geo.Country;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.SneakyThrows;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

@Component
public class HttpClient {

    public HttpResponse<JsonNode> getCityData(Country country, String cityName) throws UnirestException {
        return Unirest.get(getProperty("cityDataMainUrl") + country.getWikiDataId()
                + getProperty("cityNamePrefix") + cityName + getProperty("cityType"))
                .header(getProperty("keyHeaderName"), getProperty("rapidApiKey1"))
                .header(getProperty("hostHeaderName"), getProperty("geoDbHost"))
                .asJson();
    }

    public HttpResponse<JsonNode> getWeatherData(City city) throws UnirestException {
        return Unirest.get(getProperty("weatherDataMainUrl") + city.getLatitude()
                + getProperty("weatherLongitudePrefix") + city.getLongitude()
                + getProperty("weatherApiKey"))
                .asJson();
    }

    public HttpResponse<JsonNode> getCountryData(String name) throws UnirestException {
        return Unirest.get(getProperty("countryDataMainUrl")+ name)
                .header(getProperty("keyHeaderName"), getProperty("rapidApiKey2"))
                .header(getProperty("hostHeaderName"), getProperty("geoDbHost"))
                .asJson();
    }

    public HttpResponse<String> getCurrencyExchangeData(String from, String to) throws UnirestException {
        return Unirest.get(getProperty("currencyDataMainUrl") + from + getProperty("currencyToPrefix")
                + to + getProperty("currencyUrlClose"))
                .header(getProperty("keyHeaderName"), getProperty("rapidApiKey1"))
                .header(getProperty("hostHeaderName"), getProperty("currencyApiHost"))
                .asString();
    }

    public HttpResponse<JsonNode> getWikiData(String cityName) throws UnirestException {
        CloseableHttpClient httpClient = HttpClients.custom()
                .disableCookieManagement()
                .build();
        Unirest.setHttpClient(httpClient);
        return Unirest.get(getProperty("wikiDataMainUrl") + cityName
                + getProperty("wikiDataUrlClose"))
                .asJson();
    }

    @SneakyThrows
    private String getProperty(String key){
        try(InputStream input = new FileInputStream("src/main/resources/http.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            return prop.getProperty(key);
        }
    }
}
