package com.ASAP.CountryApp.city;

import com.ASAP.CountryApp.country.Country;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;

public class CityConnector {
    public City getData(Country country, String cityName) throws ParseException, UnirestException {
        City city = new City();
        city.setCountry(country);
        HttpResponse<JsonNode> response = connectToCityAPI(cityName, city.getCountry().getWikiDataId());
        parseData(city, response);
        return city;
    }

    private HttpResponse<JsonNode> connectToCityAPI(String name, String countryId) throws UnirestException, ParseException {
        return Unirest.get("https://wft-geo-db.p.rapidapi.com/v1/geo/cities?countryIds=" + countryId + "&namePrefix=" + name + "&types=CITY")
                .header("x-rapidapi-key", "8112b02f25mshe599c7cd4323d07p14779ajsn5613d2018835")
                .header("x-rapidapi-host", "wft-geo-db.p.rapidapi.com")
                .asJson();
    }

    private void parseData(City city, HttpResponse<JsonNode> response) {
        JSONObject data = response.getBody().getObject().getJSONArray("data").getJSONObject(0);
        city.setId(data.get("id").toString());
        city.setName(data.get("name").toString());
        city.setLatitude(data.get("latitude").toString());
        city.setLongitude(data.get("longitude").toString());
    }
}