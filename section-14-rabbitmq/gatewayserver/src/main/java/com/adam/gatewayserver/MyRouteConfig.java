package com.adam.gatewayserver;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRouteConfig {

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/api/voitures/**")
                        .filters(f -> f.circuitBreaker(config -> config.setName("voitureCircuitBreaker")
                                .setFallbackUri("forward:/contactAdmin")))
                        .uri("lb://VOITURE"))
                .route(p -> p
                        .path("/api/marques/**")
                        .uri("lb://MARQUE"))
                .build();
    }
}
