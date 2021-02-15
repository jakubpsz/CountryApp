package com.asap.country_app.controller;

import com.asap.country_app.dto.LocationDto;
import com.asap.country_app.service.LocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LocationControler {

    private final LocationService locationService;

    public LocationControler(LocationService locationService) {
        this.locationService = locationService;
    }

    //1. Wyszukujesz lokalizacje przez API
    //2. Polubiasz na froncie
    //3. Wysyła sie całość na serwer
    //4. Odbierając tworzymy z tego obiekt lokacji i zapisujemy w DB
    // (zeby mial ID) LocationController przyjmuje i robi obiekt location
    // zwraca id location
    //5. wysylasz id location i id usera
    //6. Znajduje lokacie id i user id i dodaje w obu miejscach powiazanie

    @CrossOrigin
    @PostMapping("/location")
    public LocationDto saveLocation(@RequestBody LocationDto locationDto) {
            return locationService.saveLocation(locationDto);
    }
}
