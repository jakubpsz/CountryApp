package com.ASAP.CountryApp;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CityAPI {

    public void searchByCity (String region) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://wft-geo-db.p.rapidapi.com/v1/geo/countries/" + region + "/regions"))
                .header("x-rapidapi-key", "8495dcb88dmshb311de4d68eb282p160de6jsnb5e6f42f6fcc")
                .header("x-rapidapi-host", "wft-geo-db.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }
}
