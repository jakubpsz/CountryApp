package com.ASAP.CountryApp.country;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;

public class CountryConnector {
    private HttpResponse<JsonNode> connectToAPI(String name) throws UnirestException, ParseException {
        return Unirest.get("https://wft-geo-db.p.rapidapi.com/v1/geo/countries?namePrefix=" + name)
                .header("x-rapidapi-key", "8112b02f25mshe599c7cd4323d07p14779ajsn5613d2018835")
                .header("x-rapidapi-host", "wft-geo-db.p.rapidapi.com").asJson();
    }

    public Country getData(String name) throws ParseException, UnirestException {
        Country country = new Country();
        HttpResponse<JsonNode> response = connectToAPI(name);
        parseData(country, response);
        return country;
    }

    private void parseData(Country country, HttpResponse<JsonNode> response) {
        JSONObject data = response.getBody().getObject().getJSONArray("data").getJSONObject(0);
        country.setWikiDataId(data.get("wikiDataId").toString());
        country.setCurrency(data.get("currencyCodes").toString());
        country.setName(data .get("name").toString());
        country.setCode(data.get("code").toString());
    }

}
