package com.ASAP.CountryApp;

import com.ASAP.CountryApp.currency.CurrencyExchangeDataExtractor;
import com.ASAP.CountryApp.geo_api.City;
import com.ASAP.CountryApp.geo_api.CityDataExtractor;
import com.ASAP.CountryApp.geo_api.Country;
import com.ASAP.CountryApp.geo_api.CountryDataExtractor;
import com.ASAP.CountryApp.weather.Weather;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import com.ASAP.CountryApp.weather.WeatherDataExtractor;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class App {

    public static void main(String[] args) throws UnirestException, InterruptedException, ParseException {
        SpringApplication.run(App.class, args);
        CityDataExtractor cityDataExtractor = new CityDataExtractor();
        CountryDataExtractor countryParser = new CountryDataExtractor();
        Country country = countryParser.getData("Spain");
        String currency = country.getCurrency().replace("[\"", "").replace("\"]", "");
        System.out.println(currency);

        System.out.println(new CurrencyExchangeDataExtractor().getData(currency, "PLN"));

        TimeUnit.SECONDS.sleep(2);

        City city = cityDataExtractor.getData(country, "Barcelona");
        System.out.println(city.getName());
        System.out.println(city.getCountry().getName());

        WeatherDataExtractor weatherDataExtractor = new WeatherDataExtractor();
        Weather weather = weatherDataExtractor.getData(city);
        city.setWeather(weather);

        System.out.println(city.getWeather().getDescription());
        System.out.println(city.getWeather().getTemperature());
        System.out.println(city.getWeather().getFeelsLike());
        System.out.println(city.getWeather().getPressure());
        System.out.println(city.getWeather().getWind());

    }

}
