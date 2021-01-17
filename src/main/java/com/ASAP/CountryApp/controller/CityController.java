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

//    @CrossOrigin
//    @GetMapping("/city")
//    public String getInfoForTheCity(@RequestParam(name = "country") String countryName,
//                                  @RequestParam(name = "city") String cityName) {
//        try {
//            log.info("City info checked country={} city={}", countryName, cityName);
//            return mapper.writeValueAsString(cityService.getCity(countryName, cityName));
//        } catch (Exception e) {
//            log.error("Not able to get city={} info {}", cityName, e.getMessage());
//            return null;
//        }
//    }

    @CrossOrigin
    @GetMapping("/city")
    public String getInfoForTheCity() {
            return "{\"country\":{\"wikiId\":\"Q36\",\"currency\":\"[\\\"PLN\\\"]\",\"code\":\"PL\",\"name\":\"Poland\",\"exchangeRate\":1.0,\"wikipediaPage\":\"https://en.wikipedia.org/wiki/Poland\",\"flag\":\"http://commons.wikimedia.org/wiki/Special:FilePath/Flag%20of%20Poland.svg\"},\"name\":\"Kraków\",\"id\":\"159708\",\"latitude\":\"50.061388888\",\"longitude\":\"19.937222222\",\"weather\":{\"temperature\":-12,\"feelsLike\":-16,\"description\":\"light snow\",\"pressure\":1021,\"wind\":1.03},\"wikipediaPage\":\"https://en.wikipedia.org/wiki/Krakow\"}";
    }
}
