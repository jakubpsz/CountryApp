package com.ASAP.CountryApp;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherAPI {

    public void currencyWeather() throws IOException, InterruptedException {

    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://community-open-weather-map.p.rapidapi.com/weather?q=London%2Cuk&lat=0&lon=0&callback=test&id=2172797&lang=null&units=%22metric%22%20or%20%22imperial%22&mode=xml%2C%20html"))
            .header("x-rapidapi-key", "8495dcb88dmshb311de4d68eb282p160de6jsnb5e6f42f6fcc")
            .header("x-rapidapi-host", "community-open-weather-map.p.rapidapi.com")
            .method("GET", HttpRequest.BodyPublishers.noBody())
            .build();
    HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

    System.out.println(response.body());
}
}
