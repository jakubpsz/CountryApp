package com.ASAP.CountryApp.city;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;

public class WeatherConnector {
    private HttpResponse<JsonNode> connectToWeatherAPI(City city) throws UnirestException {
        return Unirest.get("https://api.openweathermap.org/data/2.5/weather?lat=" + city.getLatitude() + "&lon=" +
                city.getLongitude() + "&appid=dfd9b909348c899e8070c1a8aa614001").asJson();
    }
    public Weather getData(City city) throws ParseException, UnirestException {
        Weather weather =  new Weather();
        HttpResponse<JsonNode> response = connectToWeatherAPI(city);
        parseData(weather, response);
        return weather ;
    }

    private void parseData(Weather weather, HttpResponse<JsonNode> response) {
        JSONObject weatherData = response.getBody().getObject().getJSONArray("weather").getJSONObject(0);
        JSONObject mainData = response.getBody().getObject().getJSONObject("main");
        weather.setDescription(weatherData.get("description").toString());
        weather.setTemperature((int) Double.parseDouble(mainData.get("temp").toString()));
        weather.setFeelsLike((int) Double.parseDouble(mainData.get("feels_like").toString()));
    }
}
