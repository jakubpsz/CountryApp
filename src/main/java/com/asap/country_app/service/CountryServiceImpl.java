package com.asap.country_app.service;

import com.asap.country_app.logic.geo.Country;
import com.asap.country_app.logic.geo.CountryDataExtractor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryDataExtractor countryDataExtractor;

    public CountryServiceImpl(CountryDataExtractor countryDataExtractor) {
        this.countryDataExtractor = countryDataExtractor;
    }

    @SneakyThrows
    @Override
    public Country getCountry(String countryName) {
        return countryDataExtractor.getData(countryName);
    }
}
