package com.ASAP.CountryApp.service;

import com.ASAP.CountryApp.logic.geo.Country;
import com.ASAP.CountryApp.logic.geo.CountryDataExtractor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    private CountryDataExtractor countryDataExtractor;

    public CountryService(CountryDataExtractor countryDataExtractor) {
        this.countryDataExtractor = countryDataExtractor;
    }

    @SneakyThrows
    public Country getCountry(String countryName) {
        return countryDataExtractor.getData(countryName);
    }
}
