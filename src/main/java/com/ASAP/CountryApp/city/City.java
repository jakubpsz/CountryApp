package com.ASAP.CountryApp.city;

import com.ASAP.CountryApp.country.Country;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class City {
    private Country country;
    private String name;
    private String id;
}
