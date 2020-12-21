package com.ASAP.CountryApp.country;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.simple.parser.ParseException;

public class Main {

    public static void main(String[] args) throws UnirestException, ParseException {
        CountryConnector countryConnector = new CountryConnector();
        Country country = countryConnector.getData("poland");
        System.out.println(country.getName() + " " + country.getWikiDataId());
    }
}
