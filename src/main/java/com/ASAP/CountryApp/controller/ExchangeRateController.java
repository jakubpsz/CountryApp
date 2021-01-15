package com.ASAP.CountryApp.controller;

import com.ASAP.CountryApp.service.ExchangeRate;
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
        } catch (Exception e) {
            log.error("Not able to get exchange rate from {} to {} error {}", from, to, e.getMessage());
            return null;
        }
    }
}
