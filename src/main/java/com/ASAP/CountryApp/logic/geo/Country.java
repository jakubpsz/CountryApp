package com.ASAP.CountryApp.logic.geo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Country {
    private String wikiDataId;
    private String currency;
    private String code;
    private String name;
    private double exchangeRate;
    private String url;
}
