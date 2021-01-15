package com.ASAP.CountryApp.logic.geo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Country {
    private String wikiId;
    private String currency;
    private String code;
    private String name;
    private double exchangeRate;
    private String wikipediaPage;
    private String flag;
}
