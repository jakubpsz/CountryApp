package com.ASAP.CountryApp.city;

import com.ASAP.CountryApp.country.Country;
import com.ASAP.CountryApp.country.CountryConnector;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.simple.parser.ParseException;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws ParseException, UnirestException, InterruptedException {
        CityConnector cityConnector = new CityConnector();
        CountryConnector countryConnector = new CountryConnector();
        Country country = countryConnector.getData("Poland");
        TimeUnit.SECONDS.sleep(3);
        City city = cityConnector.getData(country, "Warsaw");
        System.out.println(city.getName());
        System.out.println(city.getCountry().getName());
        System.out.println(city.getId());
        WeatherConnector weatherConnector = new WeatherConnector();
        Weather weather = weatherConnector.getData(city);
        city.setWeather(weather);
        System.out.println(city.getWeather().getDescription());
        System.out.println(city.getWeather().getTemperature() - 273);
        System.out.println(city.getWeather().getFeelsLike() - 273);

    }

}
