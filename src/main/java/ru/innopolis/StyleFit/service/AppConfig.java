package ru.innopolis.StyleFit.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
public class AppConfig {
    @Bean
    public RestTemplate restTemplate() {
        // Создаем и возвращаем новый экземпляр RestTemplate
        return new RestTemplate();
    }
}









