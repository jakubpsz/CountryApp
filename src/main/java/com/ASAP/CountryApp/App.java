package com.ASAP.CountryApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);

//        CityDataExtractor cityDataExtractor = new CityDataExtractor();
//        CountryDataExtractor countryParser = new CountryDataExtractor();
//        Country country = countryParser.getData("Poland");
//        String currency = country.getCurrency().replace("[\"", "").replace("\"]", "");
//        System.out.println(currency);
//
//        System.out.println(new CurrencyExchangeDataExtractor().getData(currency, "PLN"));
//
//        TimeUnit.SECONDS.sleep(2);
//
//        City city = cityDataExtractor.getData(country, "Gdańsk");
//        System.out.println(city.getName());
//        System.out.println(city.getCountry().getName());
//
//        WeatherDataExtractor weatherDataExtractor = new WeatherDataExtractor();
//        Weather weather = weatherDataExtractor.getData(city);
//        city.setWeather(weather);
//
//        System.out.println(city.getWeather().getDescription());
//        System.out.println(city.getWeather().getTemperature());
//        System.out.println(city.getWeather().getFeelsLike());
//        System.out.println(city.getWeather().getPressure());
//        System.out.println(city.getWeather().getWind());
//
//        WikiDataExtractor wikiDataExtractor = new WikiDataExtractor();
//        System.out.println(wikiDataExtractor.getData(city.getName()));
    }
}
