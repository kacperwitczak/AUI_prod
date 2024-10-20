package com.example.aui.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    public static final String weaponTypeUrl = "http://localhost:8082/";

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
