package com.asap.country_app.controller;

import com.asap.country_app.service.ExchangeRate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ExchangeRateController {
    private final ExchangeRate exchangeRate;

    public ExchangeRateController(ExchangeRate exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    @GetMapping("/exchangeRate")
    public String getExchangeRate(@RequestParam(name = "from") String from, @RequestParam(name = "to") String to) {
        try {
            log.info("Exchange rate check from {} to {}", from, to);
            return exchangeRate.getExchangeRate(from, to);
        } catch (UnirestException e) {
            log.error("Not able to get exchange rate from {} to {} error {}", from, to, e.getMessage());
            //TODO change to exception throwing
            return null;
        }
    }
}
