package com.ASAP.CountryApp.controller;

import com.ASAP.CountryApp.logic.geo.City;
import com.ASAP.CountryApp.service.CityService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CityController {

    private final CityService cityService;
    private final ObjectMapper mapper;

    public CityController(CityService cityService, ObjectMapper mapper) {
        this.cityService = cityService;
        this.mapper = mapper;
    }

    @CrossOrigin
    @GetMapping("/city")
    public String getInfoForTheCity(@RequestParam(name = "country") String countryName,
                                  @RequestParam(name = "city") String cityName) {
        try {
            log.info("City info checked country={} city={}", countryName, cityName);
            return mapper.writeValueAsString(cityService.getCity(countryName, cityName));
        } catch (Exception e) {
            log.error("Not able to get city={} info {}", cityName, e.getMessage());
            return null;
        }
    }
}
