package com.example.aui;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;


@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public RouteLocator routeLocator(
            RouteLocatorBuilder builder,
            @Value("${aui.weapon.url}") String weaponUrl,
            @Value("${aui.weapontype.url}") String weaponTypeUrl,
            @Value("${aui.gateway.host}") String host
    ) {
        System.out.println("Weapon URL: " + weaponUrl);
        System.out.println("WeaponType URL: " + weaponTypeUrl);
        System.out.println("Gateway Host: " + host);
    
        return builder.routes()
                .route("weapontypes", r -> r
                        .path("/api/weapontypes/**") 
                        .uri(weaponTypeUrl)            
                )
                .route("weapons", r -> r
                        .path("/api/weapons/**")      
                        .uri(weaponUrl)               
                )
                .build();
    }

    @Bean
    public CorsWebFilter corsWebFilter() {

        final CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.setAllowedOrigins(Collections.singletonList("*"));
        corsConfig.setMaxAge(3600L);
        corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "DELETE", "PUT"));
        corsConfig.addAllowedHeader("*");

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);

        return new CorsWebFilter(source);
    }

}
