package com.ASAP.CountryApp.controller;

import com.ASAP.CountryApp.geo_api.City;
import com.ASAP.CountryApp.service.CityService;
import com.ASAP.CountryApp.service.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CityControllerImpl implements CityController{

    CityService cityService = new CityServiceImpl();

    @GetMapping("/city")
    @ResponseBody
    @Override
    public City getInfoForTheCity(@RequestParam(name = "country") String countryName,@RequestParam(name = "city") String cityName) {
        return cityService.getCity(countryName, cityName);
    }
}
