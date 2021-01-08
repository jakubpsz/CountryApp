package com.ASAP.CountryApp.weather;

import com.ASAP.CountryApp.rest.HttpClient;
import com.ASAP.CountryApp.geo_api.City;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

public class WeatherConverter {

    public Weather getData(City city) throws UnirestException {
        Weather weather = new Weather();
        HttpResponse<JsonNode> response = new HttpClient().getWeatherData(city);
        parseData(weather, response);
        return weather;
    }

    private void parseData(Weather weather, HttpResponse<JsonNode> response) {
        JSONObject weatherData = response.getBody().getObject().getJSONArray("weather").getJSONObject(0);
        JSONObject mainData = response.getBody().getObject().getJSONObject("main");
        JSONObject windData = response.getBody().getObject().getJSONObject("wind");
        weather.setDescription(weatherData.get(("description")).toString());
        weather.setTemperature((int) Double.parseDouble(mainData.get("temp").toString()) - 273);
        weather.setFeelsLike((int) Double.parseDouble(mainData.get("feels_like").toString()) - 273);
        weather.setPressure((int) Double.parseDouble(mainData.get("pressure").toString()));
        weather.setWind(Double.parseDouble(windData.get("speed").toString()));
    }
}
