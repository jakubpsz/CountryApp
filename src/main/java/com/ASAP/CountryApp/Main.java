package com.ASAP.CountryApp;

import com.ASAP.CountryApp.currency.CurrencyExchangeParser;
import com.ASAP.CountryApp.geo_api.City;
import com.ASAP.CountryApp.geo_api.CityDataExtractor;
import com.ASAP.CountryApp.weather.Weather;
import com.ASAP.CountryApp.weather.WeatherConverter;
import com.ASAP.CountryApp.geo_api.Country;
import com.ASAP.CountryApp.geo_api.CountryParser;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.simple.parser.ParseException;

import java.io.IOException;
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
//
//
//
//
//        WeatherAPI weather = new WeatherAPI();
//        weather.currencyWeather();

//        CityAPI cityAPI = new CityAPI();
//        cityAPI.searchByCity("US");

        CityDataExtractor cityDataExtractor = new CityDataExtractor();
        CountryParser countryParser = new CountryParser();
        Country country = countryParser.getData("Spain");
        String currency = country.getCurrency().replace("[\"", "").replace("\"]", "");
        System.out.println(currency);

        System.out.println(new CurrencyExchangeParser().getData(currency, "PLN"));

        TimeUnit.SECONDS.sleep(2);

        City city = cityDataExtractor.getData(country, "Barcelona");
        System.out.println(city.getName());
        System.out.println(city.getCountry().getName());

        WeatherConverter weatherParser = new WeatherConverter();
        Weather weather = weatherParser.getData(city);
        city.setWeather(weather);

        System.out.println(city.getWeather().getDescription());
        System.out.println(city.getWeather().getTemperature());
        System.out.println(city.getWeather().getFeelsLike());
        System.out.println(city.getWeather().getPressure());
        System.out.println(city.getWeather().getWind());

    }
}
