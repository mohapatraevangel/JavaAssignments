package com.wclient.serviceproxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//@FeignClient(name="wservices", url="localhost:8082")
@FeignClient(name="wservices")
public interface WeatherServiceProxy {
    @GetMapping("weatherservice/{temp}")
    public String getWeatherInfo(@PathVariable int temp);
}

