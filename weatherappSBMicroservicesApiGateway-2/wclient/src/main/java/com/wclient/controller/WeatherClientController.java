package com.wclient.controller;

import com.wclient.dto.WeatherInfoDto;
import com.wclient.serviceproxy.WeatherServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherClientController {
    private WeatherServiceProxy weatherServiceProxy;

    @Value("${server.port}")
    private int  portNumber;

    @Autowired
    public WeatherClientController(WeatherServiceProxy weatherServiceProxy) {
        this.weatherServiceProxy = weatherServiceProxy;
    }

    @GetMapping("weatherclient/{temp}")
    public WeatherInfoDto getWeatherInfo(@PathVariable int temp) {
        String weatherInfo = weatherServiceProxy.getWeatherInfo(temp);
        return new WeatherInfoDto(weatherInfo, portNumber);
    }
}
