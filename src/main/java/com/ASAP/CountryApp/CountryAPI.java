package com.ASAP.CountryApp;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CountryAPI {



    public void searchByCountry (String country) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://restcountries-v1.p.rapidapi.com/name/" + country))
                .header("x-rapidapi-key", "8495dcb88dmshb311de4d68eb282p160de6jsnb5e6f42f6fcc")
                .header("x-rapidapi-host", "restcountries-v1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
