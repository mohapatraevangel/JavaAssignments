package com.weatherclient.serviceproxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableFeignClients("com.wclient.serviceproxy")
@EnableFeignClients
@EnableDiscoveryClient
public class Weatherserviceproxy {

            public static void main(String[] args) {
                SpringApplication.run(Weatherserviceproxy.class, args);
            }

        }
