package com.asap.country_app.service;

import com.asap.country_app.logic.geo.Country;

public interface CountryService {
    Country getCountry(String countryName);
}
