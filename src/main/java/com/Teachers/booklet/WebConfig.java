package com.Teachers.booklet;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Alkalmazza minden API végpontra
                .allowedOrigins("http://localhost:3000") // A React frontend URL-je
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Engedélyezett HTTP-módszerek
                .allowedHeaders("*") // Minden fejlécet engedélyez
                .allowCredentials(true); // Engedélyezi a hitelesítési adatokat
    }
}
