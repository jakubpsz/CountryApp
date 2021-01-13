package com.ASAP.CountryApp.service;

import com.ASAP.CountryApp.logic.currency.CurrencyExchangeDataExtractor;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Service;

@Service
public class ExchangeRateImpl implements ExchangeRate {
    private final CurrencyExchangeDataExtractor currencyExchangeDataExtractor;

    public ExchangeRateImpl(CurrencyExchangeDataExtractor currencyExchangeDataExtractor) {
        this.currencyExchangeDataExtractor = currencyExchangeDataExtractor;
    }

    @Override
    public String getExchangeRate(String from, String to) throws UnirestException {
        return currencyExchangeDataExtractor.getData(from, to);
    }
}
