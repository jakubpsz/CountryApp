package com.asap.country_app.logic.currency;

import com.asap.country_app.logic.rest.HttpClient;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Component;

@Component
public class CurrencyExchangeDataExtractor {

    //TODO change name to getExchangeRate()
    public String getData(String from, String to) throws UnirestException {
        //TODO extract httpclient to field and add dependency injection
        HttpResponse<String> response = new HttpClient().getCurrencyExchangeData(from, to);
        return response.getBody();
    }
}
