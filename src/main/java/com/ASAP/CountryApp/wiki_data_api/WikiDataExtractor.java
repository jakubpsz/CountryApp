package com.ASAP.CountryApp.wiki_data_api;

import com.ASAP.CountryApp.rest.HttpClient;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

public class WikiDataExtractor {
    public String getData(String cityName) throws UnirestException {
        HttpResponse<JsonNode> response = new HttpClient().getWikiData(cityName);
        JSONObject jsonObject =  response.getBody().getObject().getJSONObject("query").getJSONObject("pages");
        String jsonKey = jsonObject.keySet().stream().findFirst().orElseThrow();
        return jsonObject.getJSONObject(jsonKey).get("fullurl").toString();
    }
}
