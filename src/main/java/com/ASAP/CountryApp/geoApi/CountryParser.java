package com.ASAP.CountryApp.geoApi;

import com.ASAP.CountryApp.HttpClient;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

public class CountryParser {
    public Country getData(String name) throws UnirestException {
        Country country = new Country();
        HttpResponse<JsonNode> response = new HttpClient().getCountryData(name);
        parseData(country, response);
        return country;
    }

    private void parseData(Country country, HttpResponse<JsonNode> response) {
        JSONObject data = response.getBody().getObject().getJSONArray("data").getJSONObject(0);
        country.setWikiDataId(data.get("wikiDataId").toString());
        country.setCurrency(data.get("currencyCodes").toString());
        country.setName(data.get("name").toString());
        country.setCode(data.get("code").toString());
    }

}
