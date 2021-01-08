package com.ASAP.CountryApp.currency;

import com.ASAP.CountryApp.rest.HttpClient;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;

public class CurrencyExchangeParser {

    public String getData(String from, String to) throws UnirestException {
        HttpResponse<String> response = new HttpClient().getCurrencyExchangeData(from, to);
        return response.getBody();
    }
}
