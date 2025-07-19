package com.AI_Project_smart_Email_Assistance;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
	
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")
                        .allowedOrigins("https://smart-email-assistant-ai.vercel.app") // ✅ No trailing slash
                        .allowedMethods("POST", "GET", "PUT", "DELETE")
                        .allowedHeaders("*");
            }
        };
    }
}
