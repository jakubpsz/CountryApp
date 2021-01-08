package com.ASAP.CountryApp.rest;

import com.ASAP.CountryApp.geo_api.City;
import com.ASAP.CountryApp.geo_api.Country;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.InputStream;
import java.util.Properties;

public class HttpClient {

    private String properties(String key) {
        InputStream input = getClass().getClassLoader().getResourceAsStream("http.properties"))
        Properties properties = new Properties();
        properties.load(input);

        return link;
    }


    Properties properties2 = new Properties();
    String proname = "http.properties";
    String link1 = properties2.getProperty("link1");

    public HttpResponse<JsonNode> getCityData(Country country, String cityName) throws UnirestException {
        return Unirest.get(link1 + country.getWikiDataId() + "&namePrefix=" + cityName + "&types=CITY")
                .header("x-rapidapi-key", "8112b02f25mshe599c7cd4323d07p14779ajsn5613d2018835")
                .header("x-rapidapi-host", "wft-geo-db.p.rapidapi.com")
                .asJson();
    }

    public HttpResponse<JsonNode> getWeatherData(City city) throws UnirestException {
        return Unirest.get("https://api.openweathermap.org/data/2.5/weather?lat=" + city.getLatitude() + "&lon=" +
                city.getLongitude() + "&appid=dfd9b909348c899e8070c1a8aa614001").asJson();
    }

    public HttpResponse<JsonNode> getCountryData(String name) throws UnirestException {
        return Unirest.get("https://wft-geo-db.p.rapidapi.com/v1/geo/countries?namePrefix=" + name)
                .header("x-rapidapi-key", "8112b02f25mshe599c7cd4323d07p14779ajsn5613d2018835")
                .header("x-rapidapi-host", "wft-geo-db.p.rapidapi.com").asJson();
    }

    public HttpResponse<String> getCurrencyExchangeData(String from, String to) throws UnirestException {
        return Unirest.get("https://currency-exchange.p.rapidapi.com/exchange?from=" + from + "&to=" + to +"&q=1.0")
                .header("x-rapidapi-key", "8112b02f25mshe599c7cd4323d07p14779ajsn5613d2018835")
                .header("x-rapidapi-host", "currency-exchange.p.rapidapi.com")
                .asString();
    }
}
