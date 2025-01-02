package com.example.aui;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

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
        System.out.println(weaponUrl);
        System.out.println(weaponTypeUrl);
        System.out.println(host);
        var x = builder
                .routes()
                .route("weapontypes", route -> route
                        .host(host)
                        .and()
                        .path(
                                "/api/weapontypes/**",
                                "/api/weapontypes"
                        )
                        .uri(weaponTypeUrl)
                )
                .route("weapons", route -> route
                        .host(host)
                        .and()
                        .path(
                                "/api/weapons/**",
                                "/api/weapons"
                        )
                        .uri(weaponUrl)
                )
                .build();

        System.out.println(x);

        return x;
    }

}
