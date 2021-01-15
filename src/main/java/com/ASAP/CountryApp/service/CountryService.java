package com.ASAP.CountryApp.service;

import com.ASAP.CountryApp.logic.geo.Country;

public interface CountryService {
    Country getCountry(String countryName);
}
