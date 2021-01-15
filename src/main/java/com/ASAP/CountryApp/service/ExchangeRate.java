package com.ASAP.CountryApp.service;

import com.mashape.unirest.http.exceptions.UnirestException;

public interface ExchangeRate {
    String getExchangeRate(String from, String to) throws UnirestException;

}
