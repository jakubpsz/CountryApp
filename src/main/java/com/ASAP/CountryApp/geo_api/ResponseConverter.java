package com.ASAP.CountryApp.geo_api;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
class ResponseConverter {

    City convertResponseToCity(HttpResponse<JsonNode> response) {
        City city = new City();
        JSONObject data = response.getBody().getObject().getJSONArray("data").getJSONObject(0);
        city.setId(data.get("id").toString());
        city.setName(data.get("name").toString());
        city.setLatitude(data.get("latitude").toString());
        city.setLongitude(data.get("longitude").toString());
        return city;
    }
}
