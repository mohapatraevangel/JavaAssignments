package com.weatherclient.controller;

import com.weatherclient.dto.Weatherdto;
import com.weatherclient.serviceproxy.Weatherserviceproxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherClientController {
        private Weatherserviceproxy weatherServiceProxy;

        @Value("${server.port}")
        private int  portNumber;

        @Autowired
        public WeatherClientController(Weatherserviceproxy weatherServiceProxy) {
            this.weatherServiceProxy = weatherServiceProxy;
        }
        //http://localhost:8085/wclient/weatherclient/20
        @GetMapping("weatherclient/{temp}")
        public Weatherdto getWeatherInfo(@PathVariable int temp) {
            String weatherInfo = weatherServiceProxy.getWeatherInfo(temp);
            return new Weatherdto(weatherInfo, portNumber);
        }

}
