package com.ASAP.CountryApp;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyExchange {

    public void currencyCourse(String from, String to) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://currency-exchange.p.rapidapi.com/exchange?from=" + from + "&to=" + to + "&q=1.0"))
                .header("x-rapidapi-key", "8495dcb88dmshb311de4d68eb282p160de6jsnb5e6f42f6fcc")
                .header("x-rapidapi-host", "currency-exchange.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

}
