package com.asap.country_app.service;

import com.mashape.unirest.http.exceptions.UnirestException;

//TODO ExchangeRateService
public interface ExchangeRate {
    String getExchangeRate(String from, String to) throws UnirestException;

}
