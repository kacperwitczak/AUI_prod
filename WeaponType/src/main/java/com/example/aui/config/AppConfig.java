package com.example.aui.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class AppConfig {
    @Value("${aui.weapon.url}")
    private String weaponUrl;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public String getWeaponUrl() {
        return weaponUrl;
    }
}
