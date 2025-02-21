package com.example.gateway.config;

import jakarta.ws.rs.HttpMethod;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDateTime;

@Configuration
public class RouteConfig {
    @Bean
    public RouteLocator empAppRouteConfig(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route(p -> p
                        .path("/weatherclientapp/weather/**")
                        .filters(f -> f
                                .rewritePath("/weatherclientapp/weather/(?<segment>.*)", "/${segment}")
                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
                        )
                        .uri("lb://WCLIENT")
                )
                .route(p -> p
                        .path("/weatherserviceapp/weather/**")
                        .filters(f -> f
                                .rewritePath("/empstore/deptsms/(?<segment>.*)", "/${segment}")
                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
                        )
                        .uri("lb://WSERVICES")
                )
                .build();
    }
}

