package com.ASAP.CountryApp;

import com.ASAP.CountryApp.city.City;
import com.ASAP.CountryApp.city.CityConnector;
import com.ASAP.CountryApp.city.Weather;
import com.ASAP.CountryApp.city.WeatherConnector;
import com.ASAP.CountryApp.country.Country;
import com.ASAP.CountryApp.country.CountryConnector;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Currency;
import java.util.concurrent.TimeUnit;

public class Main {

    //    https://rapidapi.com/apilayernet/api/rest-countries-v1?endpoint=53aa5a08e4b0a705fcc323a6
//    https://rapidapi.com/community/api/open-weather-map
//    https://rapidapi.com/fyhao/api/currency-exchange?endpoint=53aa60c0e4b0596140341c57
//    https://rapidapi.com/wirefreethought/api/geodb-cities?endpoint=599093dde4b075a0d1d6d9ea
//
//    https://rapidapi.com/webcams.travel/api/webcams-travel

    public static void main(String[] args) throws IOException, InterruptedException, ParseException, UnirestException {

//        CountryAPI myCountry = new CountryAPI();
//        myCountry.searchByCountry("poland");
//
//        CurrencyAPI course = new CurrencyAPI();
//        course.currencyCourse("USD", "PLN");
//
//
//
//
//        WeatherAPI weather = new WeatherAPI();
//        weather.currencyWeather();

//        CityAPI cityAPI = new CityAPI();
//        cityAPI.searchByCity("US");

        CityConnector cityConnector = new CityConnector();
        CountryConnector countryConnector = new CountryConnector();
        Country country = countryConnector.getData("Poland");

        TimeUnit.SECONDS.sleep(3);

        City city = cityConnector.getData(country, "Warsaw");
        System.out.println(city.getName());
        System.out.println(city.getCountry().getName());

        WeatherConnector weatherConnector = new WeatherConnector();
        Weather weather = weatherConnector.getData(city);
        city.setWeather(weather);

        System.out.println(city.getWeather().getDescription());
        System.out.println(city.getWeather().getTemperature() - 273);
        System.out.println(city.getWeather().getFeelsLike() - 273);

    }
}
