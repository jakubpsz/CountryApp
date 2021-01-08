package com.ASAP.CountryApp.geoApi;

import com.ASAP.CountryApp.HttpClient;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;

public class CityParser {
    public City getData(Country country, String cityName) throws ParseException, UnirestException {
        City city = new City();
        city.setCountry(country);
        HttpResponse<JsonNode> response = new HttpClient().getCityData(country, cityName);
        parseData(city, response);
        return city;
    }

    private void parseData(City city, HttpResponse<JsonNode> response) {
        JSONObject data = response.getBody().getObject().getJSONArray("data").getJSONObject(0);
        city.setId(data.get("id").toString());
        city.setName(data.get("name").toString());
        city.setLatitude(data.get("latitude").toString());
        city.setLongitude(data.get("longitude").toString());
    }
}