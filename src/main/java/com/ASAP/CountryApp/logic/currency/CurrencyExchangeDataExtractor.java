package com.ASAP.CountryApp.logic.currency;

import com.ASAP.CountryApp.logic.rest.HttpClient;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Component;

@Component
public class CurrencyExchangeDataExtractor {

    public String getData(String from, String to) throws UnirestException {
        HttpResponse<String> response = new HttpClient().getCurrencyExchangeData(from, to);
        return response.getBody();
    }



}
