package com.asap.country_app.logic.weather;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
//TODO HttpResponseToWeatherConverter
    //TODO ResponseWeatherConverter
class ResponseConverterWeather {

    private static final int KELVIN_DEGREE_OFFSET = 273;

    Weather convertResponseToWeather(HttpResponse<JsonNode> response) {
        Weather weather = new Weather();
        JSONObject weatherData = response.getBody().getObject().getJSONArray("weather").getJSONObject(0);
        JSONObject mainData = response.getBody().getObject().getJSONObject("main");
        JSONObject windData = response.getBody().getObject().getJSONObject("wind");
        weather.setDescription(weatherData.get(("description")).toString());
        weather.setTemperature((int) Double.parseDouble(mainData.get("temp").toString()) - KELVIN_DEGREE_OFFSET);
        weather.setFeelsLike((int) Double.parseDouble(mainData.get("feels_like").toString()) - KELVIN_DEGREE_OFFSET);
        weather.setPressure((int) Double.parseDouble(mainData.get("pressure").toString()));
        weather.setWind(Double.parseDouble(windData.get("speed").toString()));
        return weather;
    }
}
