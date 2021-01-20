package com.asap.country_app.logic.weather;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Weather {
    private int temperature;
    private int feelsLike;
    private String description;
    private int pressure;
    private double wind;
}
