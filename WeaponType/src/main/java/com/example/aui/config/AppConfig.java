package com.example.aui.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    public static final String weaponUrl = "http://localhost:8081/";

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
