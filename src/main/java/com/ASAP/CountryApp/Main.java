package com.ASAP.CountryApp;

import java.io.IOException;
import java.util.Currency;

public class Main {

    //    https://rapidapi.com/apilayernet/api/rest-countries-v1?endpoint=53aa5a08e4b0a705fcc323a6
//    https://rapidapi.com/community/api/open-weather-map
//    https://rapidapi.com/fyhao/api/currency-exchange?endpoint=53aa60c0e4b0596140341c57
//    https://rapidapi.com/wirefreethought/api/geodb-cities?endpoint=599093dde4b075a0d1d6d9ea
//
//    https://rapidapi.com/webcams.travel/api/webcams-travel

    public static void main(String[] args) throws IOException, InterruptedException {

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

        CityAPI cityAPI = new CityAPI();
        cityAPI.searchByCity("US");



    }
}
