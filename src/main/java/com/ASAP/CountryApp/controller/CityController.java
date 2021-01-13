package com.ASAP.CountryApp.controller;

import com.ASAP.CountryApp.logic.geo.City;
import com.ASAP.CountryApp.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

    private final CityService cityService;
    private final Logger logger = LoggerFactory.getLogger(CityController.class);

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/city")
    public City getInfoForTheCity(@RequestParam(name = "country") String countryName,@RequestParam(name = "city") String cityName) {
        try {
            logger.info("City info checked country={} city={}",countryName, cityName);
            return cityService.getCity(countryName, cityName);
        }catch (Exception e){
            logger.error("Not able to get city={} info {}", cityName, e.getMessage() );
            return null;
        }
    }
}
