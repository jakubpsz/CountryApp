package com.ASAP.CountryApp.logic.weather;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
class ResponseConverterWeather {
    Weather convertResponseToWeather(HttpResponse<JsonNode> response) {
        Weather weather = new Weather();
        JSONObject weatherData = response.getBody().getObject().getJSONArray("weather").getJSONObject(0);
        JSONObject mainData = response.getBody().getObject().getJSONObject("main");
        JSONObject windData = response.getBody().getObject().getJSONObject("wind");
        weather.setDescription(weatherData.get(("description")).toString());
        weather.setTemperature((int) Double.parseDouble(mainData.get("temp").toString()) - 273);
        weather.setFeelsLike((int) Double.parseDouble(mainData.get("feels_like").toString()) - 273);
        weather.setPressure((int) Double.parseDouble(mainData.get("pressure").toString()));
        weather.setWind(Double.parseDouble(windData.get("speed").toString()));
        return weather;
    }
}
